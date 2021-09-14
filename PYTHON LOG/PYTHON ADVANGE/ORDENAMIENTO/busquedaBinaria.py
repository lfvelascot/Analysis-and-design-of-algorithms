def busquedaBinaria(lista,elemento):
	izq = 0
	der = len(lista)-1
	while izq <= der:
		medio = int((izq+der)/2)
		if lista[medio] == elemento:
			return medio
		elif lista[izq] == elemento:
			return izq
		elif lista[der] == elemento:
			return der
		else :
			izq = izq+1
			der = der-1
	return -1

lista = ['Casa','Cocina','Perro','Gato','Telefono']
elemento = 'Perro'
r = busquedaBinaria(lista,elemento)
if r is not -1:
	print("El elemento se encontro en la posicion "+(str(r)))
else :
	print("No encontramos el elemento: "+elemento)

elemento = 'Cama'
r = busquedaBinaria(lista,elemento)
if r is not -1:
	print("El elemento se encontro en la posicion "+(str(r)))
else :
	print("No encontramos el elemento: "+elemento)
