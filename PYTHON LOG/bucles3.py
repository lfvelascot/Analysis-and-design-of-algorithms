def email():
	contador = 0;
	valido=False
	email=input("Introduce tu email: ")
	for i in range(len(email)):
		if (email[i] =="."):
			contador=contador+1
		elif (email[i] == "@"):
			arroba = True

	if(contador >=1 and arroba == True):
		print("Email Correcto")
	else:
		print("Email incorrecto")


def rango():
## Uso de range hasta un rango numerico
	for i in range(5):
		print(f"Valor de la variable {i}")
## Uso de range entre dos valores
	for i in range(2,7):
		print(f"Valor de la variable {i}")
##Uso de Range indicando el tamaño de las iteraciones
	for i in range(5,50,3):
		print(f"Valor de la variable {i}")

def num1al100():
	for i in range(1,101):
		print(i,end=" ")

def contrasena():
	cont=input("INGRESE LA CONTRASEÑA:  ")
	espacio = False;
	if len(cont) < 8:
		print("La contraseña tiene menos de 8 caracteres")
	else :
		for i in range(len(cont)):
			if cont[i] == " ":
				espacio = True;

		if espacio	== True:
			print("La contraseña tiene espacion")
		else :
			print("Contrseña aceptable")


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

