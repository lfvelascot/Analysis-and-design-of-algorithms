import tkinter
from tkinter import messagebox
import socket
import threading
from random import randint
import os 

win = tkinter.Tk()
idt = str(randint(0,50)) # Identificador de cada uno de los clientes
win.title("Cliente Banco N° "+idt) # titulo de la ventana con el Id del cliente
win.geometry("500x500") # dimensiones dela ventana
ip = "192.168.0.14" #IP del servidor
port = 5000 # Puerto del servidor
cliente_id = "Cliente "+idt #Nombre del cliente
estadoVar = "" # Cadena con el estado del servidor
icon = "icons/bank.png" # ubicacíón del icono 
flag = False #control de impresiónes en el campo de texto
fin = True # control del cierre del cliente
ck = None# Se utiliza para almacenar información del cliente

def getInfo():
    #Se usan variables globales que permitan ser usados por otros metodos
    global flag
    global ck
    global fin
    while fin:
        try: 
            data = ck.recv(1024)#Se utiliza para recibir la información enviada por el servicio
            text.insert(tkinter.END, data.decode("utf-8"))#Display en el cuadro de mensaje
            flag = False
        except:
            ck = None
            if flag is not True:
                estadoVar = "Sin conexion"
                text.insert(tkinter.END,"- "+estadoVar+"\n")
                flag = True

def connectServer():
    global ck
    try:
        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)#socked       ipv4 o ipv6 y acuerdos relacionados
        client.connect((ip, port))# ¡Conecta ip y número de puerto! ! ! 1: Tenga en cuenta que el número de puerto de entrada es de tipo str y aquí debe pasarse en tipo int
        # 2: el parámetro de bind () tiene la forma de una tupla
        client.send(cliente_id.encode("utf-8"))
        ck = client
        t = threading.Thread(target=getInfo)
        estadoVar = "Conectado"
        text.insert(tkinter.END,"- "+estadoVar+"\n")
        t.start()
    except:
        estadoVar ="Sin conexion"
        text.insert(tkinter.END,"- "+estadoVar+"\n")

def reconectar():
    global flag
    if flag is True:
        connectServer()

def pedirPrestamo():
    st = salario.get()
    sendStr = cliente_id+":"+st
    ck.send(sendStr.encode("utf-8"))
    salario.set("")


#Componentes de la interfaz
win.iconphoto(False, tkinter.PhotoImage(file=icon))
salario = tkinter.Variable()
labeltext= tkinter.Label(win, text="INVERSIONES", font=('Helvetica', 18, 'bold')).grid(padx=5,pady=5,row=0, column=0, columnspan=2)
labelUse = tkinter.Label(win, text="ID: ").grid(padx=5,pady=5,row=1, column=0)
entryUser = tkinter.Label(win, text=cliente_id).grid(padx=5,pady=5,row=1, column=1,sticky="ew")
Salario = tkinter.Label(win, text="Valor a invertir: $").grid(padx=5,pady=5,row=2, column=0, sticky="ew")
labeltext= tkinter.Label(win, text="Respuesta",font=('Helvetica', 18, 'bold')).grid(padx=5,pady=5,row=4, column=0, columnspan=2)
button1 = tkinter.Button(win, text="Enviar", command=pedirPrestamo, bg="#62DF9B").grid(padx=5,pady=5,row=3, column=0,columnspan=2, sticky="ew")
entrySalario = tkinter.Entry(win, textvariable=salario).grid(padx=5,pady=5,row=2, column=1,sticky="ew")
text = tkinter.Text(win,pady=5, height=10, width=60)
text.grid(padx=5,pady=5,row=5, column=0,columnspan=2)
connectServer()
button2 = tkinter.Button(win, text="Reconectar", command=reconectar, bg="#DF6264").grid(padx=5,pady=5,row=7, column=0,columnspan=2, sticky="ew")

#Metodo para controlar el cierre del cliente y su hilo 
def on_closing():
    global fin
    if messagebox.askokcancel("Cerrar", "Quiere cerrar el cliente?"):
        win.destroy()
        ck.close()
        fin = False
        os._exit(0)

#Aplicación del protocolo 
win.protocol("WM_DELETE_WINDOW", on_closing)
win.mainloop()