def seleccion(arrayN,opc):
    for indice in range(0, len(arrayN)):
        menor = arrayN[indice]
        posicion = indice
        for subindice in range(posicion, len(arrayN)):

            if arrayN[subindice] > menor:
                menor = arrayN[subindice]
                posicion = subindice


        if posicion != indice:
            aux = arrayN[indice]
            arrayN[indice] = arrayN[posicion]
            arrayN[posicion] = aux

    if (opc == 1):
        mostrar_arreglo(arrayN)
    else :
        mostrar_arreglo(arrayN[::-1])
    
def mostrar_arreglo(arrayN):
    for i in range(len(arrayN)):
        print('Elemento '+'-------> '+str(arrayN[i]))


def leer_arreglo():
    longitud = int(input("Tamaño del arreglo: "))
    arrayN = [0]*longitud
    index = 0
    for iten in arrayN:
        arrayN[index] = int(input("Digite el numero "+str(index)+" del arreglo: "))
        index = index + 1

    print("---------SELECCION----------")
    print("-------------DESC-------------")
    seleccion(arrayN,1)
    print("-----------ASC---------------")
    seleccion(arrayN,0)

leer_arreglo()
