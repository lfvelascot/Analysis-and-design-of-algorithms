class Coche():

	#Atributos del objeto
	def __init__(self):
		#MInicializacion de valores
	    self.__largoChasis= 250
	    self.__anchoChasis=120
	    self.__ruedas=4
	    self.enMarcha=False


	#Acciones del objeto
	def arrancar (self,arrancamos):
		self.enMarcha=arrancamos
		if(self.enMarcha):
			return "El coche esta en marcha"
		else:
			return "El coche esta quieto"

	def estado(self):
		print ("El vehiculo tiene ",self.__ruedas," ruedas\nUn ancho de ",
		self.__anchoChasis," cm y un alto de ",self.__largoChasis," cm.")

#Intancia del objeto
print("-----------------------------------")
miCoche=Coche()
print(miCoche.arrancar(True))
miCoche.estado()
print("-----------------------------------")
miCoche2=Coche()
print(miCoche2.arrancar(False))
miCoche2.__ruedas = 5
miCoche2.estado()
print("-----------------------------------")

