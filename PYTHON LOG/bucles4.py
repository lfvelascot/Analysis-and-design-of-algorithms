import math

def edad():
	edad=int(input("Edad del usuario: "))
	while edad<0 or edad>100:
		print("Edad erronea, vuelve a intentarlo")
		edad = int(input("Edad de nuevo: "))


	print(" F I N \nEdad = ",edad)


def raices():
	print("Calculadora de raices")
	num=int(input("INGRESE EL NUMERO A EVALUAR: "))
	i=1
	while num < 0:
		print("No se pueden hallar raices de números negativos")

		if i == 2:
			print("Muchos intentos")
			break;

		num=int(input("INGRESE EL NUMERO A EVALUAR: "))
		if num <0:
			i=i+1

	if i<2:
		sol=math.sqrt(num)
		print("La raices cuadrada de ",num," es ",sol)


#raices()

def numerosinf():
	x = -999
	y = int(input("Ingrese un numero : "))
	while y > x:
		x = y
		y = int(input("Ingrese un siguiente numero : ")) 

	print("FIN DEL PRGRAMA")

numerosinf()


def numpos():
	con = 0;
	y = int(input("Ingrese un numero : "))
	while y >0:
		con = con +y;
		y = int(input("Ingrese un siguiente numero : ")) 
	print("Sumatoria : ",con)

numpos()


