

##for i in ["x","y","z",2]:
##	print("Hola ",end="")


def validarcorreo():
	correo = input("Ingrese su correo : ")
	contador=0
	arroba = False
	for i in correo:
		if (i =="."):
			contador=contador+1
		elif (i == "@"):
			arroba = True

	if(contador >=1 and arroba == True):
		print("Email Correcto")
	else:
		print("Email incorrecto")



def rango():
	for i in range(5):
		print(i, " xxxx")

rango()
#validarcorreo()
#validarcorreo()
#validarcorreo()


