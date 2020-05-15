###HERENCIA

class Vehiculos():

	def __init__(self,marca,modelo):
		#Datos ingresados
		self.marca=marca
		self.modelo=modelo
		#Datos por defecto
		self.enMarcha=False
		self.acelera=False
		self.frena=False

	def arrancar(self):
		self.enMarcha=True

	def acelerar(self):
		self.acelera=True;

	def frenar (self):
		self.frena = True

	def estado(self):
		print("Marca : ",self.marca,"\nModelo : ",self.modelo,"\n¿En Marcha? ",self.enMarcha,"\n¿Acelera? ",self.acelera,"\n¿Frena? ",self.frena)


##Cuando se hace herencia,en la clase hija
##se ingresa la clasepadre entre parentesis
class Moto(Vehiculos):
	hcaballito="*No hace caballito*"
	def caballito(self):
		self.hcaballito="*Haciendo caballito*"

	def estado(self):
		print("Marca : ",self.marca,"\nModelo : ",self.modelo,"\n¿En Marcha? ",self.enMarcha,"\n¿Acelera? ",self.acelera,"\n¿Frena? ",self.frena,"\n ",self.hcaballito)



class Furgoneta (Vehiculos):

	def carga(self, cargar):
		self.cargada=cargar
		if(self.cargada):
			return "La Furgoneta esta cargada"
		else:
			return "La furgoneta no esta cargada"


class vElectrico():

	def __init__(self):
		self.autonomia =100

	def cargaE(self):
		self.cargado=True


class biciElectrica(vElectrico,Vehiculos):
	pass




