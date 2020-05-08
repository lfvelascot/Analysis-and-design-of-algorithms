
def ejercicio1():
	print("PROGRAMA DE BECAS")
	distancia=float(input("Ingrese distancia a la que vive de la escuela: "))
	nhermanos=int(input("Ingrese el numero de hermanos: "))
	sfamiliar=int(input("Ingrese el salario familiar: $"))
	print("Distancia: ",distancia,"km.\nN° hermanos: ",nhermanos,"\nSalario familiar: $",sfamiliar,"\n")
	#if distancia>40 and nhermanos>2 and sfamiliar<=20000: Las tres deben ser TRUE
	if distancia>40 or nhermanos>2 or sfamiliar<=20000:
		print("El estudiante ha ganado una beca\n")
	else:
		print("El estudiante no ha ganado una beca\n")

##ejercicio1()
##ejercicio1()
##ejercicio1()


def ejercicio2():
	asss= "- Informatica Grafica\n - Pruebas de software\n - Usabilidad y accesibilidad"
	print("Asignaturas: \n",asss)
	opc=input("Ingrese la asignatura escogida.")
	asig=opc.lower()
	asis=asss.lower()
	if asig in (asis):
		print("Asignatura elegida: ",asig,"\n")
	else:
		print(asig,"No esta en la lista de asignaturas\n")


ejercicio2()
ejercicio2()


