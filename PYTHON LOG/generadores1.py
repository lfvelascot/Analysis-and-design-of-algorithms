def generarN(limite):
	num=1
	miLista=[]
	while num<limite:
		miLista.append(num*2)
		num=num+1
	return miLista


print (generarN(10))


def generaP(limite):
	num=1
	while num<limite:
		yield num*2
		num=num+1

#for i in devuelvePares:
#	print(i)


devuelvePares=generaP(10)

print(next(devuelvePares))

print("Stop sfg")

print(next(devuelvePares))

print(next(devuelvePares))

print("Stop sfg")

print(next(devuelvePares))

print(next(devuelvePares))

print("Stop sfg")

print(next(devuelvePares))



