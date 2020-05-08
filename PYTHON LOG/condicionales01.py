print("1. Programa de evaluacion de alumnos")
print("   ingrese su nota")

nota=input()

def evaluacion (nota):
	valoriacion="Aprobada"
	if nota<5:
		#Si la nota es menor a 5, la variable 'Valoracion' cambiara a "Suspenso"
		valoriacion="Suspendida"
	return valoriacion

print("La materia esta : ",evaluacion(int(nota)))

print("2. Programa de evaluacion de alumnos")
print("   ingrese su nota")
nota=input()

print("La materia esta : ",evaluacion(int(nota)))