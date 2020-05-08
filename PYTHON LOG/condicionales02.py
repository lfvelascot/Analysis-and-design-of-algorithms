def edad():
	print ("Verificar edad")
	edad=int(input("Introduce tu edad: "))

	if edad >100 or edad <0:
		print("Edad incorrecta")
	elif edad < 18:
		print ("No puedes pasar - Eres menor de edad")
	else :
		print("Puedes pasar - eres mayor de edad")
	print("////////////")
edad()
edad()
edad()
edad()

def nota():
	print ("Verificar nota")
	nota=int(input("Introduce tu nota: "))
## If usado para simular un Switch - case
	if nota<5:
		print("Insuficiente")

	elif nota<6:
		print("Suficiente")

	elif nota<7:
		print("Bien")

	elif nota<8:
		print("notable")

	else:
		print("Sobresaliente")
	print("////////////")
nota()
nota()
nota()
nota()
nota()
