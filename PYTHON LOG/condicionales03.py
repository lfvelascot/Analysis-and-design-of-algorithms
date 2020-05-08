def edad():
	print(" Evaluar edad ")
	edad = int(input("Ingrese su edad : "))
	if 0<edad<100:
		print("La edad es correcta\n")
	else:
		print("Edad incorrecta\n")
edad()
edad()
edad()

def salarios ():
	salariopr=int(input("Ingrese el salario del presidente: $"))
	print("Salario Presidente: ",salariopr)
	salariod=int(input("Ingrese el salario del director: $"))
	print("Salario Presidente: ",salariod)
	salariopja=int(input("Ingrese el salario del jefe de area: $"))
	print("Salario Presidente: ",salariopja)
	salarioad=int(input("Ingrese el salariod el administrador: $"))
	print("Salario Presidente: ",salarioad)

	if salarioad<salariopja<salariod<salariopr:
		print("Todo esta bien\n")
	else:
		print("Los salarios no son correctos\n")


salarios()
salarios()
salarios()
salarios()
salarios()