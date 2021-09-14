import threading
import time
import random

class Barberia:
    def __init__(self):
        #mecanismos y variables de control clientes y acceso a la sala
        ####### inicializa cada uno con el tipo y valor oportuno####
        #####puedes cambiar los nombres o añadir nuevos#######
        #controla la entrada en la sala de espera
        self.entrarEnSala= threading.Semaphore(3)
        #controla el número de clientes en la sala
        self.clientesEnSala= 0 #Valor de inicialización para el estado de la sala
        #garantiza exclusion para modificacion de variables de control de sala o acceso a secciones
        self.exclusionMutuaSala= threading.Lock() # Plantea hacer individual el proceso de hilos (clientes)
        
        #mecanismos y variables de control del barbero
        ####### inicializa cada uno con el tipo y valor oportuno #######
        #####puedes cambiar los nombres o añadir nuevos#######
        #controla el acesso al sillon de corte, puede poner clientes en espera y ser despertados
        self.sillon=threading.Condition()
        #controla lel estado del barbero
        self.barberoOcupado = False
        #puede poner al barbero a dormir y ser despertado
        self.dormir = threading.Condition()
        

    def actividadBarbero(self):
        while True:
            ### INCLUYE EL CÓDIGO NECESARIO PARA PROTOCOLO INICIAL   ###
            ### consultar en exclusion mutua los clientes qUe hay en la sala###
            ### si no hay clientes esperando se pone a dormir hasta que le despierten ####
            with self.exclusionMutuaSala:
                if self.clientesEnSala ==0:
                    with self.dormir:
                        print("El barbero esta en descanso")
                        self.dormir.wait()
            print("El barbero da paso a un cliente\n")
            ###  INTRODUCE EL CÓDIGO PARA CAMBIAR EL ESTADO DEL BARBERO ###
            with self.sillon:
                self.barberoOcupado=True
            print("El barbero corta a un cliente\n")
            time.sleep(1) #Ejecución de actividad de barbero
            ###  INTRODUCE EL CÓDIGO PARA CAMBIAR EL ESTADO DEL BARBERO Y AVISAR A LOS CLIENTES DE LA SALA ###
            with self.sillon:
                self.barberoOcupado=False
                self.sillon.notifyAll()
                            
            
    def actividadCliente(self):

            print("El "+threading.currentThread().name+" entra en la barberia \n")
            ### INCLUYE EL CÓDIGO NECESARIO PARA PROTOCOLO INICIAL   ###
            ### consultar en exclusion mutua el estado ddel barbero###
            ### según estado entrar en la sala o no ####
            ### según estado entrar despertar al babero o no ####
            ### el orden del protocolo no tiene que ser el que reflejan los comentaios ####
            with self.sillon:
                if self.barberoOcupado:
                    with self.exclusionMutuaSala:
                        print("El "+threading.currentThread().name+ " esta en la sala \n")
                        self.entrarEnSala.acquire()
                        self.clientesEnSala+=1
                        self.sillon.wait()
                    print("Acaba la espera del "+threading.currentThread().name+ "\n")
                    with self.exclusionMutuaSala:
                        if self.clientesEnSala>0:
                            self.clientesEnSala-=1
                    self.entrarEnSala.release()
                else:
                	with self.dormir:
                		self.dormir.notify()
            print ("Esta en el sillon el "+threading.currentThread().name+"\n")
            time.sleep(2)
            print ("El "+threading.currentThread().name+" abandona la barbería\n")
            

if __name__=="__main__":
        barberia= Barberia()
        ### INCLUYE EL CÓDIGO NECESARIO PARA CREAR E INICIALIZAR LOS HILOS  ###
        t1 = threading.Thread(target = barberia.actividadBarbero, name="Barbero")
        t1.start()
        ### clientes####
        i = 1
        while i < 6:
            t2 = threading.Thread(target = barberia.actividadCliente, name="Cliente "+str(i)+" ")
            if barberia.clientesEnSala != 3:
            	t2.start()
            	i+=1
