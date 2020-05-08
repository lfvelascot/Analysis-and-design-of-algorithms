def devuelvem():
	print("PROGRAMA PARA COMPARAR DOS NUMEROS")
	n1=int(input("Ingrese el primer numero: "))
	n2=int(input("Ingrese el segundo numero: "))
	if n1>n2:
		print(n1," es mayor que ",n2,"\n")
	else :
		print(n2," es mayor que ",n1,"\n")
devuelvem()

#Por diccionario
def listaDatos():
	print("PROGRAMA PARA ALMACENAR DATOS 1")
	datos={}
	datos["Nombre"] = input("Ingrese su nombre: ")
	datos["Direccion"] = input("Ingrese su direccion: ")
	datos["Telefono"] = input("Ingrese su telefono: ")
	print("Sus datos son ",datos,"\n")

listaDatos()
#Por lista
def listaDatos2():
	print("PROGRAMA PARA ALMACENAR DATOS 2")
	nombre=input("Ingrese su nombre: ")
	direccion=input("Ingrese su direccion: ")
	telefono=input("Ingrese su telefono: ")
	datos=[nombre,direccion,telefono]
	print("Sus datos son: \nnombre: ",datos[0],"\ndireccion: ",datos[1],"\ntelefono: ",datos[2],"\n")

listaDatos2()

def mediaA():

	n1=int(input("Ingrese el primer número: "))
	n2=int(input("Ingrese el segundo número: "))
	n3=int(input("Ingrese el tercer número: "))
	print("La media arimetica de ",n1,", ",n2," y ",n3," es",((n1+n2+n3)/3),"\n")

mediaA()