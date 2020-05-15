from io import open
archivo_texto = open ("archivo.txt","r")
archivo_texto.seek(11)
print(archivo_texto.read ())
archivo_texto.close()

archivo_texto = open ("archivo.txt","r")
#Se detiene en la posicion indicada
print(archivo_texto.read (11))
archivo_texto.close()

archivo_texto = open ("archivo.txt","r")
archivo_texto.seek(len(archivo_texto.read())/2)
print("\n",archivo_texto.read ())
archivo_texto.close()

archivo_texto = open ("archivo.txt","r+") #r+ = lectura y escritura

lista_texto = archivo_texto.readlines()
lista_texto[2] = "Esta linea ha sido incluida desde el exterior\n"
archivo_texto.seek(0)
archivo_texto.writelines(lista_texto);
archivo_texto.seek(0)
print(archivo_texto.read ())
archivo_texto.close()