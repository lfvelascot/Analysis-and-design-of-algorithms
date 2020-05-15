from tkinter  import *

raiz = Tk()
frame1 = Frame(raiz,width = 400, height = 400)
frame1.pack()

minombre = StringVar()

cuadro1 = Entry(frame1,textvariable=minombre)
cuadro1.grid(row = 0,column =1,padx=10, pady = 10)
cuadro1.config(fg = "red", justify = "center")

label1 = Label(frame1, text = "Nombre:")
label1.grid(row =0,column =0,sticky ="w",padx=10, pady = 10)

labelp = Label (frame1,text = "Contraseña:")
labelp.grid(row =1,column =0,sticky ="w",padx=10, pady = 10)

cuadropassword = Entry(frame1)
cuadropassword.grid(row =1,column =1,sticky ="w",padx=10, pady = 10)
cuadropassword.config(show ="*")

cuadro2 = Entry(frame1)
cuadro2.grid(row = 2,column =1,padx=10, pady = 10)

label2 = Label(frame1, text = "Apellido:")
label2.grid(row =2,column =0,sticky ="w",padx=10, pady = 10)  

cuadro3 = Entry(frame1)
cuadro3.grid(row = 3,column =1,padx=10, pady = 10)

label3 = Label(frame1, text = "Dirección:")
label3.grid(row =3,column =0, sticky ="w",padx=10, pady = 10)  

label4 = Label(frame1, text = "Comenario:")
label4.grid(row =4,column =0, sticky ="w",padx=10, pady = 10)  
textoComent = Text(frame1, width = 16, height = 5)
textoComent.grid(row = 4, column = 1,padx=10, pady = 10)
#Barra desplzamiento
scrollv = Scrollbar(frame1, command = textoComent.yview)
scrollv.grid(row = 4,column = 2, sticky = "nsew")
textoComent.config(yscrollcommand = scrollv.set)

def codigoBoton ():
	minombre.set("Felipe")

boton1 = Button(raiz, text = "Enviar",command = codigoBoton)
boton1.pack()

raiz.mainloop()

