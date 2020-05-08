def devuelveciudades(*ciudades):
	for elemento in ciudades:
		for subElemento in elemento:
			yield subElemento

ciudades_devueltas=devuelveciudades("Madrid","Barcelona","Bilboa","Valencia")

print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))

#def devuelveciudades2(*ciudades):
#	for elemento in ciudades:
#		yield elemento

#ciudades_devueltas2=devuelveciudades2("Madrid","Barcelona","Bilboa","Valencia")

#print(next(ciudades_devueltas2)
#print(next(ciudades_devueltas2))
#print(next(ciudades_devueltas2))
#print(next(ciudades_devueltas2))
