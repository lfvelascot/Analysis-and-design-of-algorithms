import tkinter
import socket, threading

win = tkinter.Tk()  # Crea la ventana principal
win.title('Servidor del supermercado')
win.geometry("500x500")
users = {}#Diccionario de usuario, también puede conectarse a la base de datos
ip = "192.168.0.14"
tablero = ""
icon = "icons/server.png" # ubicacíón del icono 
flag = False
port = 5000

text = tkinter.Text(win, height=25, width=60)
labeltext = tkinter.Label(win, text='LOG DEL SERVIDOR',font=('Helvetica', 18, 'bold')).grid(row=0, column=0)
text.grid(row=1, column=0)
win.iconphoto(False, tkinter.PhotoImage(file=icon))

def run(ck, ca):
    global flag
    try:
        userName = ck.recv(1024)# Aceptar como unidad la información enviada por el cliente en 1k. La información recibida aquí es de tipo byte
        users[userName.decode("utf-8")] = ck#Decodificar y almacenar información del usuariofont=('Helvetica', 18, 'bold')
        printStr = userName.decode("utf-8") + " conexión\n"#Muestre si la conexión se realizó correctamente en el cuadro de visualización de la conexión
        text.insert(tkinter.END, printStr)
        while True:
            rData = ck.recv(1024)# Aceptar como unidad la información enviada por el cliente en 1k. La información recibida aquí es de tipo byte
            dataStr = rData.decode("utf-8")
            infolist = dataStr.split(":")#Dividir la cadena para obtener el nombre de usuario que se enviará y la información enviada por el cliente
            d = int (infolist[1])
            r = ""
            ganancia = int(d*0.15)
            total = int(d-ganancia)
            r = "- Total sin descuento: $"+str(d)+"\n Descuento (15%): $" + str(ganancia)+"\n TOTAL A PAGAR: $"+str(total)+"\n"
            tablero = "- Consulta realizada por "+str(infolist[0])+" - Valor compra $"+str(d) 
            users[infolist[0]].send((r).encode("utf"))
            text.insert(tkinter.END, tablero+"\n")
            # El cliente que quiere enviar información envía información al cliente objetivo
            flag = False
    except:
        if flag is not True:
            text.insert(tkinter.END, "- El servidor esta apagado\n")# Mostrado en la ventana de información
            flag = True


def start():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)#socked       ipv4 o ipv6 y acuerdos relacionados
    server.bind((ip, port))# ¡IP vinculante y número de puerto! ! ! 1: Tenga en cuenta que el número de puerto de entrada es de tipo str y aquí debe pasarse en tipo int
        # 2: el parámetro de bind () tiene la forma de una tupla
    server.listen(10)# Configure el monitoreo y establezca el número máximo de conexiones
    text.insert(tkinter.END, "- El servidor se inició correctamente\n")# Mostrado en la ventana de información
    while True:# El bucle infinito se usa aquí porque el servidor simulado debe estar ejecutándose todo el tiempo
        ck, ca = server.accept()# Aceptar la información del cliente conectado
                # Donde ca es una tupla compuesta por ip y número de puerto, ck información sobre el cliente
        t = threading.Thread(target=run, args=(ck, ca))#Abre un hilo cada vez que un cliente está conectado
                # Los parámetros de la función entrante en la función Thread también están en forma de tuplas
        t.start()#Hilo abierto


def startSever():
    s = threading.Thread(target=start)#Habilitar un hilo para iniciar el servidor
    s.start()#Hilo abierto

# Lo siguiente trata sobre el funcionamiento de la interfaz
startSever()
win.mainloop()