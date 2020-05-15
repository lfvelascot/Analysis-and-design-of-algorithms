import pickle

fichero = open ("losCoches","rb")
lista = pickle.load(fichero)
fichero.close()
for i in lista:
	i.estado()