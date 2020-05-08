def suma (x,y):
	return x+y
def resta (x,y):
	return x-y
def multi (x,y):
	return x*y
def div (x,y):
	try: 
		return x/y
	except ZeroDivisionError:
		print("No se puede dividir entre cero.")
		return "Operacion erronea"

while True:
	try:
		opc = int(input( "1. Suma / 2. Resta / 3. Multiplicacion / 4. Divicion / 0. Salida;   "))
		if opc == 0:
			print("A D I O S")
			break
	except ValueError:
		print("Se ingreso un valor no numerico.")
		continue

	try:
		x = int(input("INGRESE EL PRIMER NUMERO : "))
		y = int(input("INGRESE EL SEGUNDO NUMERO : "))
	except ValueError:
		print("Se ingreso un valor no numerico.")
		continue

	if opc == 1:
		print(x,"+",y,"=",suma(x,y))
	elif opc == 2:
		print(x,"-",y,"=",resta(x,y))
	elif opc == 3:
		print(x,"x",y,"=",multi(x,y))
	elif opc == 4:
		print(x,"/",y,"=",div(x,y))
	else:
		print("OPCION INVALIDA")



def divicion ():
	print("D I V C I Ó N")
	try: 
		x = float(input("INGRESE EL PRIMER NUMERO : "))
		y = float(input("INGRESE EL SEGUNDO NUMERO : "))
		return x/y
	except ZeroDivisionError:
		print("No se puede dividir entre cero.")
		return "Operacion erronea"
	except ValueError:
		print("Se ingreso un valor no numerico.")


divicion()


