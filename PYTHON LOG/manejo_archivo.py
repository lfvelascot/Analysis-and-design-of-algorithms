from io import open
archivo_texto = open ("archivo.txt","w")
frase ="Estupendo diía para estudiar Python \n H O Y"
archivo_texto.write(frase);
archivo_texto.close()
archivo_texto = open ("archivo.txt","r")
texto = archivo_texto.read ()
archivo_texto.close()
print(texto)
archivo_texto = open ("archivo.txt","r")
texto = archivo_texto.readlines ()
archivo_texto.close()
print(texto[0])
archivo_texto = open ("archivo.txt","a")
archivo_texto.write ("\n siempre es una buena ocacion para estudiar python")
archivo_texto.close()


