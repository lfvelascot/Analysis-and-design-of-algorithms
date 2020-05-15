from tkinter import *

root = Tk()
miFrame = Frame(root, width = 400, height = 400)
miFrame.pack()
Label(miFrame,text = "Este es un label", fg = "Red", font = ("Arial Black" ,18)).place(x= 10, y = 10)
imagen= PhotoImage(file="mundo.gif", format="gif -index 2")
Label(miFrame, image=imagen).place(x = 10, y = 40)
root.mainloop()