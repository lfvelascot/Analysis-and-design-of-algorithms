#
#Clase de los objetos tipo Mochila en donse encontraran los atributos, construcotira 
#y metodos encapsulados en esta clase
#
class Mochila:
#Construcotira del objeto con un valor de coma flotante de entrada
    def __init__(self, capacidad):
        self.peso = 0
        self.lista = []
        self.valor = 0
        self.capacidad = capacidad
    ###  Metodo de recuperacion del peso de una mochila 
    def getPeso(self):
    	return self.peso  
    ###  Metodo de recuperacion de la capacidad de una mochila 
    def getCapacidad(self):
    	return self.capacidad 	
    ### Metodo de indexado de los Objetos en la mochila
    def guardarObjeto(self,objeto):
    	self.lista.append(objeto)
    	self.peso += objeto.getPeso()
    	self.valor += objeto.getValor()
    ### Metodo de impresion de los objetos contenidos en la mochila 
    def mostrarMochila 	(self):
    	print ("-------- M O C H I L A --------")
    	for i in self.lista:
    		i.mostrarObjeto()	
    	print("PESO MAXIMO: ",self.capacidad," Kg."
    		"\nPESO FINAL: ",self.peso," Kg."
    		"\nVALOR ALMACENADO $:",self.valor)	
#
#Clase de los objetos tipo Objeto en donde encontraran los atributos, construcotira 
#y metodos encapsulados en esta clase
#                              
class Objeto:
	#Constructora del objeto con un valor entero y dos de coma flotante como valores de entrada
    def __init__(self,i, peso, valor):
        self.i = i
        self.peso = peso
        self.valor = valor
        self.valorporunidad = self.valor/self.peso
    ##Metodo de recuperacion del peso del objeto
    def getPeso(self):
    	return self.peso  
    ##Metodo de recuperacion del valor del objeto
    def getValor(self):
	    return self.valor 	
    ### Metodo de impresion del objeto
    def mostrarObjeto(self):
        print ("Objeto:",self.i," - Valor: $",self.valor," - Peso:",self.peso," gr.")         
##Metodo de ordenamiento QuickSort de forma recursiva
def quickSort(lista):
    izquierda = []
    centro  = []
    derecho = []
    if len(lista)>1:
    	pivote = lista [0]
    	for i in lista:
      		if i.valorporunidad < pivote.valorporunidad:
       			izquierda.append(i)
      		elif i.valorporunidad == pivote.valorporunidad:
          		centro.append(i)
      		elif i.valorporunidad > pivote.valorporunidad:
          		derecho.append(i)
    	return quickSort(izquierda) + centro + quickSort(derecho)
    else:
    	return lista
###
#def resultado (mochila,objetos):
#	i = (len(objetos)-1)
#	while(mochila.getPeso() < mochila.getCapacidad() and i >= 0):
#		objeto = objetos[i]
#		if ((mochila.getPeso() + objeto.getPeso())  <= mochila.getCapacidad()):
#			mochila.guardarObjeto(objeto)
#		i-=1 
#	return mochila

#Metodo encargado del indexado de los objetos ala mochila
#Evaluando su peso para ser ingresados a la mochila
def resultador (mochila,objetos,i):
	if (i == -1 or mochila.getPeso() >= mochila.getCapacidad()):
		return mochila
	else :
		objeto = objetos[i]
		if ((mochila.getPeso() + objeto.getPeso())  <= mochila.getCapacidad()):
			mochila.guardarObjeto(objeto)	
		return resultador (mochila,objetos,i-1)

#Metodo de carga de los objetos a la lista a manipular
def llenarLista(cantidadObjetos):
	lista = []
	for i in range (cantidadObjetos):
		print ("---------- OBJETO ",i," ----------")
		lista.append(Objeto (i,float(input("Peso del objeto: ")),float(input("Valor del objeto: "))))
	return lista


print ("-------- PROBLEMA DE LA MOCHILA --------\n",
	"En este problema se plantea la necesidad de almacenar\n",
	"dentro de una mochila m elementos los cuales sean elegidos\n",
	"por su valor, y que estos no superen el peso de la mochila.\n",
	"Se le pediran los siguiente datos:\n",
	" - Peso maximo de la mochila.\n",
	" - Cantidad de objetos a evaluar (N).\n",
	" - N Objetos a evaluar.\n",
	"-------------------------------------------")
pesoMax = float (input("Peso maximo de la mochila: "))
cantidadObjetos = int (input("Cantidad de objetos a evaluar: "))
#resultado(Mochila (pesoMax),quickSort(llenarLista(cantidadObjetos))).mostrarMochila()
resultador(Mochila (pesoMax),quickSort(llenarLista(cantidadObjetos)),cantidadObjetos-1).mostrarMochila()
print ("-------- FIN PROGRAMA --------")
