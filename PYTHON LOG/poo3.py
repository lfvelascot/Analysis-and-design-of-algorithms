class Persona():
	def __init__ (self,nombre, edad, lugar_residencia):
		self.nombre = nombre

		self.edad = edad

		self.lugar_residencia = lugar_residencia

	def descripcion(self):
		print ("Nombre : ",self.nombre," Edad: ",
			self.edad," Residencia: ",self.lugar_residencia)


class Empleado(Persona):
	def __init__(self,nombre,edad,lugar_residencia,
		salario,antiguedad):
		super().__init__(nombre,edad,lugar_residencia)
		self.salario = salario
		self.antiguedad = antiguedad


	def descripcion (self):
		super().descripcion()
		print ("Salario: ",self.antiguedad," Antigüedad: ",
			self.antiguedad," años")


##Empleado creado haciendo uso de la clase instanciada y la clase padre
antonio = Empleado ("Antonio",25,"España",1500,15)
print ("-----------Datos Empleado-------")
antonio.descripcion()
##Comprobacion de que el ojeto creado si es una instancia de las clases creadas
print(isinstance(antonio,Persona))
print(isinstance(antonio,Empleado))
manuel = Persona("Manuel",30,"Colombia")
print(isinstance(manuel,Persona))
print(isinstance(manuel,Empleado))