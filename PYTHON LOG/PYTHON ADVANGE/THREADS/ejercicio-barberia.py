from threading import Thread, Lock, Event
import time
import threading

exclusionMutuaSala=Lock() 

class Barberia:
    
    agendaClientes = []
    
    def __init__(self,barbero):
        # Dedine el método barbero y el número de silllas presentes en la barberia
        self.barbero = barbero
        self.sillas = 3
        #garantiza exclusion para modificacion de variables de control de sala o acceso a secciones
        #self.exclusionMutuaSala=threading.Lock()
    def BarberiaAbierta(self):
        print('Barbero da apertura a barberia')
        workingThread = Thread(target = self.actividadBarbero)
        workingThread.start()

    def actividadBarbero(self):   
        
        while True:
            ### INCLUYE EL CÓDIGO NECESARIO PARA PROTOCOLO INICIAL   ###
            ### consultar en exclusion mutua los clientes qUe hay en la sala###
            ### si no hay clientes esperando se pone a dormir hasta que le despierten ####
            exclusionMutuaSala.acquire()
            if len(self.agendaClientes) >0:
                c = self.agendaClientes.pop(0)
                exclusionMutuaSala.release()
                print('El barbero corta a cliente\n')
                self.barbero.cortar(c)
                c.join()
            else:
                exclusionMutuaSala.release()
                print('Barbero a dormir\n')
                barbero.sleep()
                print('Barbero despertó\n')
            
            
    def actividadCliente(self,cliente):
        exclusionMutuaSala.acquire()
        print('{0} llega a la puerta de la barbería \n'.format(c.name))
        if len(self.agendaClientes) == self.sillas:
        	print('Sala de espera está llena, {0} se retira de la barberia\n'.format(cliente.name))
        	exclusionMutuaSala.release()
        else:
        	print('{0} Esta en la sala de espera \n'.format(c.name))
        	self.agendaClientes.append(cliente)
        	exclusionMutuaSala.release()
        	barbero.wakeup()
        cliente.join()


class Barbero:

    barberoTrabajando = Event()

    def sleep(self):
        self.barberoTrabajando.wait()

    def wakeup(self):
        self.barberoTrabajando.set()

    def cortar(self,cliente):
    	cliente.join()
    	self.barberoTrabajando.clear()
    	print('El {0}, Terminó el servicio \n'.format(c.name))
    	time.sleep(5)
    	print('{0}, abandona la barberia \n'.format(cliente.name))
        
if __name__=="__main__":
    barbero = Barbero()
    barberia = Barberia(barbero)
    barberia.BarberiaAbierta()
    for i in range (1,7):
        #clientes.append(Cliente('Cliente '+str(i)))
        time.sleep(3)
        c = threading.Thread( name="Cliente "+str(i))
        c.start()
        barberia.actividadCliente(c)
        c.join()

    