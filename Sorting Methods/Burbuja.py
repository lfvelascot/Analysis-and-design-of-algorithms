def burbuja(arrayN,opc):
    if (opc == 0):
        for n in range(len(arrayN) - 1, 0, -1):
            for i in range(n):
                if arrayN[i] < arrayN[i + 1]:
                    temp = arrayN[i]
                    arrayN[i] = arrayN[i + 1]
                    arrayN[i + 1] = temp
    else :
        for n in range(len(arrayN) - 1, 0, -1):
            for i in range(n):
                if arrayN[i] > arrayN[i + 1]:
                    temp = arrayN[i]
                    arrayN[i] = arrayN[i + 1]
                    arrayN[i + 1] = temp 
    mostrar_arreglo(arrayN)
    
def mostrar_arreglo(arrayN):
    for i in range(len(arrayN)):
        print('Elemento '+'-------> '+str(arrayN[i]))


def leer_arreglo():
    longitud = int(input("Tamaño del arreglo -------> "))
    arrayN = [0]*longitud
    index = 0
    for iten in arrayN:
        arrayN[index] = int(input("Digite el numero "+str(index)+" del arreglo: "))
        index = index + 1
    print("---------BURBUJA---------------")
    print("---------DESC------------------")
    burbuja(arrayN,0)
    print("---------ASC-------------------")
    burbuja(arrayN,1)

leer_arreglo()
