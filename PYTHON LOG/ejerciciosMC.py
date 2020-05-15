correo = input ("Introducir el correo electronico : ")
if (correo.count("@") == 1 and
	(correo.find("@") != 0 and correo.find("@") != len(correo)-1) ):
	print ("Direccion de correo valida")
else :
	print ("Direccion de correo invalida")