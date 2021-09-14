def busquedaTexto1(texto, busqueda):
	aux= ''
	for i in texto:
		aux = aux+i
		if aux != busqueda[0:len(aux)]:
			aux = ''
		elif aux == busqueda:
			return True
	return False

def busquedaTexto2(texto,busqueda):
	if len(busqueda) > len(texto):
		return False
	else:
		for i in range (len(texto)):
			if busqueda == texto[i:i+len(busqueda)]:
				return True
		return False



if busquedaTexto1('Esta es una cadena de prueba','es'):
	print ('YESSSS')
else:
	print('FALSE')

if busquedaTexto2('Esta es una cadena de prueba','es'):
	print ('YESSSS')
else:
	print('FALSE')




