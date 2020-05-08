dicc1={"Alemania":"Berlin","Francia":"Paris","UK":"Londres","España":"Madrid"}
#Acceder al valor de una clave en el Dicc
print(dicc1["Francia"])
print("///////")
#
print("Diccionario 1\n",dicc1)
print("///////")
#Añadir 
dicc1["Italia"]="Peru"
print("Diccionario 1\n",dicc1)
print("///////")
#Cambiar valor de una clave
dicc1["Italia"]="Roma"
print("Diccionario 1\n",dicc1)
print("///////")
#Eliminar elemento 
del dicc1["UK"]
print("Diccionario 1\n",dicc1)
print("///////")
#### Diccionario de elementos variados
dicc2={"Alemania":"Berlin","Jordan":23,"¿Mayor de 18?":True}
print("Diccionario de elementos variados:\n",dicc2)
tupla=["España","Italia","Francia","UK"]
## Diccionario compuesto por claves de una tupla
dicc3={tupla[0]:"Madrid",tupla[1]:"Roma",tupla[2]:"Francia",tupla[3]:"Londres"}
print("Diccionario con claves de una tupla:\n",dicc3)
## Diccionario que almacene una tupla
europa=tupla
asia=["China","Japon","Corea del norte","Indonesia"]
dicc4={"Europa":europa,"Asia":asia}
print("Diccionario compuesto de tuplas\n",dicc4)