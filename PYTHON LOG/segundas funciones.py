#Esta es una funcion sin valores de entrada ni retorno
def suma1():
	num1=5
	num2=7
	print(num1+num2)

#Esta es una funcion que recibe valores de entrada pero no retorna ninguno
def suma2(num1,num2):
	print(num1+num2)

# Esta es una funcion con valores de entrada y retorno
def suma3(num1,num2):
	resultado=num1+num2
	return resultado

#Llama de la funcion sin valores de entrada ni retorno
print("Funcion sin valores de entrada ni retorno")
suma1()

#Llamada de la funcion con valores de entrada y sin retorno
print("Funcion solo con valores de entrada")
suma2(20,10)
#Impresion de la funcion con valores de entrada y retorno
print("Funcion de suma con valores de entrada y retorno",suma3(20,10))



