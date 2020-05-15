import pickle

class Persona ():

	def __init__ (self,nombre, genero, edad):
		self.nombre = nombre
		self.genero = genero;
		self.edad = edad
		print("Se ha creado una persona nueva con el nombre :",self.nombre)

	def __str__ (self):
		return "{} - {} - {}".format(self.nombre,self.genero,self.edad)
 
p = Persona("Sandra","Femenino",29)
p1 = Persona("Andres","Masculino",28)
p2= Persona("Felipe","Maculino",47)

class ListaPersonas:
	personas = []

	def __init__(self):
		listaDePersonas = open("ficheroExterno","ab+")
		listaDePersonas.seek(0)
		try :
			self.personas = pickle.load(listaDePersonas)
			print("Se han cargado {} personas del fichero externo".format(len(self.personas)))
		except:
			print ("El fichero esta vacio")
		finally:
			listaDePersonas.close()
			del(listaDePersonas)

	def agregarPersonas(self, p):
		self.personas.append(p)
		self.guardarPersonasEnFicheroExterno()

	def mostrarPersonas(self):
		for i in self.personas:
			print(p)

	def guardarPersonasEnFicheroExterno(self):
		listaDePersonas = open("ficheroExterno","wb")
		pickle.dump(self.personas,listaDePersonas)
		listaDePersonas.close()
		del(listaDePersonas)

misLista = ListaPersonas()
#misLista.agregarPersonas(p)
#misLista.agregarPersonas(p1)
#misLista.agregarPersonas(p2)
misLista.mostrarPersonas()