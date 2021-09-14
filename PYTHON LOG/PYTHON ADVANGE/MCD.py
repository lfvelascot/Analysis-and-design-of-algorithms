def divisores (numero):
	if numero == 0:
		return []
	else:
		div = []
		for i in range (1,numero+1):
			if numero%i == 0:
				div.append(i)
		return div

def mcd (x,y):
	l1 = divisores(x)
	if x == y:
		return l1.pop()
	elif x == 0  or y == 0:
		return -2
	else :
		l2 = divisores(y)
		if len(l1) < len(l2):
			return findmCD(l2,l1,len(l2))	
		else:
			return findmCD(l1,l2,len(l1))	
	return -1	

def findmCD(l1,l2,x):
	i = 1
	while i != x+1:
		a = l1[len(l1)-i] 
		if a in l2:
			return a
		else :
			i += 1
	return 1
		
def respuesta(a,b):
	r = mcd(a,b)
	if r != -2:
		print ("El MCD entre ",a," y ",b," es :",r)
	else:
		print ("No se admiten valores de cero (0)")	

def respuesta2(a):
	l = divisores(a)
	if len(l) != 0:
		print ("Divisores de ",a,": ",divisores(a))
	else:
		print ("No se admiten valores de cero (0)")

def programa (a,b):
	print("R E S U L T A D O S")
	respuesta2(a)
	respuesta2(b)
	respuesta(a,b)


programa(int (input("Ingrese el valor 1: ")),int (input("Ingrese el valor 2: ")))






