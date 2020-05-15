nombreUusuario = input("Introduce tu nombre de usuario: ")
print ("El nombre es : ",nombreUusuario.upper())
nombreUusuario = input("Introduce tu nombre de usuario: ")
print ("El nombre es : ",nombreUusuario.lower())
nombreUusuario = input("Introduce tu nombre de usuario: ")
print ("El nombre es : ",nombreUusuario.capitalize())


edad = input("Ingrese la edad : ")
while (edad.isdigit() == False):
	print ("Por favor introducir un valor numerico")	
	edad = input("Ingrese la edad : ")

if (int (edad) < 18):
		print ("no puede pasar")
else :
		print ("si puede pasar")



