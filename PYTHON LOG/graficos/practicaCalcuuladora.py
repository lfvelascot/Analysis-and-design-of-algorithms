from tkinter import *

raiz = Tk()
raiz.config(bg = "black")
frame = Frame(raiz)
frame.config(bg = "gray40")
frame.pack()
#-------------PANTALLA
numeroPantalla = StringVar()
operacion = ""
resultado = 0
pantalla = Entry(frame, textvariable = numeroPantalla)
pantalla.grid(row  = 1, column = 1, padx = 10, pady = 10, columnspan = 4)
pantalla.config(bg = "Black", fg = "Green1",justify = "right")

#------------- METODOS
def numerPulsado (num):
	global operacion
	m = numeroPantalla.get()
	coma = m.count(num)
	if (operacion != ""):
		numeroPantalla.set(num)
		operacion= ""
	else :	
		numeroPantalla.set(numeroPantalla.get()+num)

def borrarContenido():
	numeroPantalla.set(numeroPantalla.get()[:-1])

def suma(num):
	global operacion
	global resultado
	m = numeroPantalla.get()
	if (len(m) != 0):
		resultado+= int (num) 
		operacion = "suma"
		numeroPantalla.set(resultado)

def total ():
	global resultado
	numeroPantalla.set(resultado+float(numeroPantalla.get()))
	resultado = 0


#----------- FILA 1
boton7 = Button (frame, text = "7", width = 3, command=lambda:numerPulsado("7"))
boton8 = Button (frame, text = "8", width = 3, command=lambda:numerPulsado("8"))
boton9 = Button (frame, text = "9", width = 3, command=lambda:numerPulsado("9"))
botondiv = Button (frame, text = "/", width = 3)
boton7.grid(row = 2, column = 1)
boton8.grid(row = 2, column = 2)
boton9.grid(row = 2, column = 3)
botondiv.grid(row = 2, column = 4)
#----------- FILA 2
boton4 = Button (frame, text = "4", width = 3, command=lambda:numerPulsado("4"))
boton5 = Button (frame, text = "5", width = 3, command=lambda:numerPulsado("5"))
boton6 = Button (frame, text = "6", width = 3, command=lambda:numerPulsado("6"))
botonx = Button (frame, text = "x", width = 3)
boton4.grid(row = 3, column = 1)
boton5.grid(row = 3, column = 2)
boton6.grid(row = 3, column = 3)
botonx.grid(row = 3, column = 4)
#----------- FILA 3
boton1 = Button (frame, text = "1", width = 3, command=lambda:numerPulsado("1"))
boton2 = Button (frame, text = "2", width = 3, command=lambda:numerPulsado("2"))
boton3 = Button (frame, text = "3", width = 3, command=lambda:numerPulsado("3"))
botonres = Button (frame, text = "-", width = 3)
boton1.grid(row = 4, column = 1)
boton2.grid(row = 4, column = 2)
boton3.grid(row = 4, column = 3)
botonres.grid(row = 4, column = 4)
#----------- FILA 4
boton0 = Button (frame, text = "0", width = 3, command=lambda:numerPulsado("0"))
botoncoma = Button (frame, text = ",", width = 3, command=lambda:numerPulsado(","))
botonigual = Button (frame, text = "=", width = 3,command =lambda:total())
botonsuma = Button (frame, text = "+", width = 3,command = lambda:suma(numeroPantalla.get()))
boton0.grid(row = 5, column = 1)
botoncoma.grid(row = 5, column = 2)
botonigual.grid(row = 5, column = 3)
botonsuma.grid(row = 5, column = 4)

botonBorrar = Button(frame,text = "DEL",width = 4, command=borrarContenido)
botonBorrar.grid(row = 6 , column= 3, padx = 10, pady = 10, columnspan = 2)
raiz.mainloop()
