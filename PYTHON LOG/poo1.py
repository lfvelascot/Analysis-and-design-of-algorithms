class Coche():
	#Bloque de atributos
##Constructora
	def __init__(self):
		#MInicializacion de valores
	    self.largoChasis= 250
	    self.anchoChasis=120
	    ##Variable encapsulada
	    self.__ruedas=4
	    ##
	    self.enMarcha=False
    #Bloque de acciones
	def arrancar(self,arrancamos):
		self.enMarcha=arrancamos

		if(self.enMarcha == True):
			chequeoI=self.__chequeo()

		if(self.enMarcha and chequeoI == True):
			return "El vehiculo esta en marcha"

		elif (self.enMarcha and chequeoI == False):
		    return "Algo ha ido mal" 

		else:
			return "El vehiculo esta quieto"

	def __chequeo(self):
		print("Inicio chequeo interno")
		self.gasolina="OK"
		self.aceite="mal"
		self.puertas="cerradas"

		if(self.gasolina == "OK" and self.aceite == "OK" and self.puertas == "cerradas"):
			return True
		else:
			return False

	def caracterizticas(self):
		print("El vehiculo tiene ",self.__ruedas," ruedas\nUn ancho de ",
			self.anchoChasis," cm y un alto de ",self.largoChasis," cm.")


print("************************************")
miCoche=Coche() #Instanciar clase
print(miCoche.arrancar(True))
print(miCoche.caracterizticas())
####################### COCHE 2 #############
print("************************************")
miCoche2=Coche()
miCoche2.ruedas=
print(miCoche2.arrancar(False))
print("222",miCoche2.caracterizticas())