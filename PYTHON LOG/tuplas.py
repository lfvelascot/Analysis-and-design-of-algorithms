tupla1=("Hola","Mi",25,"nombre",25)
print("Elemento en la posicion 2 : ",tupla1[2])
print("///////")
#Convertir una tupla a lista
lista=list(tupla1)
print("Tupla convertirda en lista\n",lista)
print("///////")
##Convetir una lista a tupla
tuplar=tuple(lista)
print("Lista convertida en tupla\n",tuplar)
print("///////")
## Buscar un valor en una tupla
print("Hola" in tupla1)
print("///////")
##Saber cuantas veces ets aun elemento en una lista
print("Cuantas veces esta 25 en la tupla? ",tupla1.count(25))
print("///////")
##Saber la longitud de una tupla
print("Longitud de la tupla : ",len(tupla1))
print("///////")
#Tupla unitaria
tuplaunitaria=(258,)
print("Tupla de un solo elemento ",tuplaunitaria)
print(len(tuplaunitaria))
print("///////")
# Tupla sin parentesis
tuplan = 10,20,30,40
print("Tupla sin parentesis : ",tuplan)
print("///////")
#Distribucion de valores de una tupla en variables
nombre,dia,mes,agnio,cosa=tupla1
print(nombre)
print(dia)
print(mes)
print("///////")
