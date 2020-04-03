def Gnome (arrayN,opc):
        if (opc == 0):
                i=1
                while i<len(arrayN):
                        if arrayN[i]<=arrayN[i-1]:
                                i=i+1
                        else:
                                temp=arrayN[i-1]
                                arrayN[i-1]=arrayN[i]
                                arrayN[i]=temp
                                if i>1:
                                        i=i-1
        else :
                i=1
                while i<len(arrayN):
                        if arrayN[i]>=arrayN[i-1]:
                                i=i+1
                        else:
                                temp=arrayN[i-1]
                                arrayN[i-1]=arrayN[i]
                                arrayN[i]=temp
                                if i>1:
                                        i=i-1
        mostrar_arreglo(arrayN)
	

def mostrar_arreglo(arrayN):
    for i in range(len(arrayN)):
        print('Elemento '+'-------> '+str(arrayN[i]))


def leer_arreglo():
    longitud = int(input("Tamaño del arreglo ------->  "))
    arrayN = [0]*longitud
    index = 0
    for iten in arrayN:
        arrayN[index] = int(input("Digite el numero "+str(index)+" del arreglo: "))
        index = index + 1
    print("---------GNOME-----------------")
    print("---------DESC------------------")
    Gnome(arrayN,0)
    print("---------ASC-------------------")
    Gnome(arrayN,1)

leer_arreglo()
