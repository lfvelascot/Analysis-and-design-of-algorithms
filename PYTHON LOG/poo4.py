def desplazamientoVehiculo(vehiculo):
	vehiculo.desplazamiento()

class Coche ():

	def desplazamiento (self):
		print ("Me desplazo utilizando cuatro ruedas")

class Moto():

	def desplazamiento (self):
		print ("Me desplazo utilizando dos ruedas")

class Camnion():

	def desplazamiento (self):
		print ("Me desplazo utilizando seis ruedas")


miVehiculo = Moto()
miVehiculo.desplazamiento()
miVehiculo2 = Coche()
miVehiculo2.desplazamiento()
miVehiculo3 = Camnion()
miVehiculo3.desplazamiento()

##Aplicacion del polimorfismo
vehiculo1 = Camnion()
desplazamientoVehiculo(vehiculo1)