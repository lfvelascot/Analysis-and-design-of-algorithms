import pickle

class Vehiculo():
	def __init__(self,marca,modelo):
		self.marca=marca
		self.modelo=modelo
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
		print("Marca : ",self.marca,"\nModelo : ",self.modelo,
			"\n¿En Marcha? ",self.enMarcha,"\n¿Acelera? ",
			self.acelera,"\n¿Frena? ",self.frena,"\n")

coche1 = Vehiculo("Mazda","MXS")	
coche2 = Vehiculo("Seat","Leon")	
coche3 = Vehiculo("Renault","Magane")	

coches = [coche1,coche2,coche3]	

import pickle
fichero = open ("losCoches","wb")
pickle.dump(coches,fichero)
fichero.close()
del(fichero)

fichero = open ("losCoches","rb")
lista = pickle.load(fichero)
fichero.close()
for i in lista:
	i.estado()