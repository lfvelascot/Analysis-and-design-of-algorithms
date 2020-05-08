def espacios():
	texto="pildoras informaticas"

	print("Tamaño",(len(texto)))
	cont=0
	for letra in texto:
		if letra==" ":
			continue
		cont+=1

	print(cont)

def correos():
	email=input("Ingrese correo : ")
	for i in email:
		if i=="@":
			arroba=True
			break;
	else:
		arroba=False

	print(arroba)

correos()





