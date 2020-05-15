from tkinter  import *

raiz = Tk()
raiz.title("Ventana de pruebas")
raiz.resizable(1,1)
raiz.iconbitmap("logo.ico")
raiz.geometry("650x450")
raiz.config(bd = 15)
raiz.config(relief = "groove")
raiz.config(cursor ="hand2")
raiz.config(bg="SkyBlue2")

miFrame = Frame()
#miFrame.pack(side = "right", anchor = "n")
miFrame.pack(fill = "both", expand = "True")
#miFrame.pack()
miFrame.config(bg="Pink")
miFrame.config(width = "550", height = "400")
miFrame.config(bd = 15)
##Revisar tipos de bordes
miFrame.config(relief = "groove")
miFrame.config(cursor ="pirate")
raiz.mainloop()





