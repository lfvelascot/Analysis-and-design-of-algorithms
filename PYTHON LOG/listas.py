#inicilizar una lista
miLista=["Maria","Pepe","Marta","Yo"]
#Imprimir toda la lista
print(miLista[:])
print("///////")
#Imprimir un elemento por medio de su indice
print(miLista[2])
print("///////")
#Imprimir en un rango de indices
print(miLista[:3])
print("///////")
print(miLista[1:2])
print("///////")
print(miLista[2:])
#Añadir un nuevo elemento al final
miLista.append("mamá")
print(miLista[:])
print("///////")
#Añadir un valor en cualquier posicion de la lista
miLista.insert(2,"Kiara")
print(miLista[:])
print("///////")
#Añadir varios elementos a la lista
miLista.extend(["carmen","cecilia"])
print(miLista[:])
print("///////")
#Saber la posicion de un elemento en la lista
print(miLista.index("Kiara"))
print("///////")
#Saber si un elemento se encuentra en la lista
print("Kiara" in miLista)
print("///////")
print("Marlen" in miLista)
print("///////")
#### lista con distintos elementos
listaV=[20,"Cama",True,5.15]
print(listaV[:])
print("///////")
##Eliminar un elemento
miLista.remove("Kiara")
print(miLista[:])
print("///////")
##Eliminar el ultimo elemento de la lista
miLista.pop()
print(miLista[:])
print("///////")
#
miLista2=["Cama","Comida"]
##Unir dos listas
miLista3=miLista+miLista2
print(miLista3[:])
print("///////")
##Repetir una lista n veces
listaV=listaV*3
print(listaV[:])
print("///////")