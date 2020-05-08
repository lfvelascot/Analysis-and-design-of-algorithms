import math

def evaluacion (edad):
	if edad <0:
		raise TypeError("No existen edad negativas")
	if edad < 20:
		return "Eres muy joven"
	elif edad < 40 :
		return "Eres joven"
	elif edad < 65:
		return "Eres mayor"
	elif edad < 100:
		return "See you in heaven"

edad=int(input("Ingresa tu edad: "))

print(evaluacion(edad))

def raices(numero):
	if numero<0:
		raise ValueError ("Numero no puede ser negativo")
	else:
		return math.sqrt(numero)


opc=(int(input("Introduce valor : ")))

try:
	print("Raiz cuadrada de ",opc," es ",raices(opc))

except ValueError as ErrorDeNumeroNegativo:
	print("Numero negativo")


print(" FIN ")


def edad(x):
	return edad+10






