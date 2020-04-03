def siGap(gap):
	gap=(gap*10)//13
	if gap<1:
		return 1
	return gap

def Peine(arrayN,opc):
    n=len(arrayN)
    gap=n
    flag=True
    while(gap!=1 or flag==True):
            gap=siGap(gap)
            flag=False
            for i in range(0,n-gap):
                if (opc == 0):
                        if arrayN[i]>arrayN[i+gap]:
                                    aux=arrayN[i]
                                    arrayN[i]=arrayN[i+gap]
                                    arrayN[i+gap]=aux
                                    flag=True
                else:
                        if arrayN[i]<arrayN[i+gap]:
                                    aux=arrayN[i]
                                    arrayN[i]=arrayN[i+gap]
                                    arrayN[i+gap]=aux
                                    flag=True
    mostrar_arreglo(arrayN)


def mostrar_arreglo(arrayN):
    for i in range(len(arrayN)):
        print('Elemento '+'-------> '+str(arrayN[i]))


def leer_arreglo():
    longitud = int(input("Tamaño del arreglo : "))
    arrayN = [0]*longitud
    index = 0
    for iten in arrayN:
        arrayN[index] = int(input("Digite el numero "+str(index)+" del arreglo: "))
        index = index + 1

    print("---------ASC----------")
    Peine(arrayN,0)
    print("---------DESC----------")
    Peine(arrayN,1)

leer_arreglo()
