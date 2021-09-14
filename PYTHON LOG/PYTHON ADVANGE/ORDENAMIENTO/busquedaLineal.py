def busquedaLineal(lista, elemento):
	for i in lista:
		if i == elemento:
			return lista.index(i)
	return -1


lista = ['Casa','Cocina','Perro','Gato','Telefono']
elemento = 'Perro'
r = busquedaLineal(lista,elemento)
if r is not -1:
	print("El elemento se encontro en la posicion "+(str(r)))
else :
	print("No encontramos el elemento: "+elemento)

elemento = 'Cama'
r = busquedaLineal(lista,elemento)
if r is not -1:
	print("El elemento se encontro en la posicion "+(str(r)))
else :
	print("No encontramos el elemento: "+elemento)


