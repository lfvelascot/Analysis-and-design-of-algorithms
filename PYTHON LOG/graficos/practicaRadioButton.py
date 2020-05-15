from tkinter import *
r = Tk()
varOption = IntVar()
def imprimir ():
	if(varOption.get() == 1):
		etiqueta.config(text = "Has elegido masculino")
	elif (varOption.get() == 2):
		etiqueta.config(text = "Has elegido Femenino")
	else:
		etiqueta.config(text = "Has elegido femenino")
Label(r, text="Genero : ").pack()
Radiobutton(r, text ="Masculino",variable = varOption, value = 1,command = imprimir).pack()
Radiobutton(r, text ="Femenino",variable = varOption, value = 2,command = imprimir).pack()
Radiobutton(r, text ="Otro",variable = varOption, value = 3,command = imprimir).pack()
etiqueta =Label(r)
etiqueta.pack()
r.mainloop()