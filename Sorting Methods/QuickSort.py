def quick_sort(arrayN,opc):
    quick_sort_auxiliar(arrayN, 0, len(arrayN) - 1)
    if (opc == 0):
        mostrar_arreglo(arrayN)
    else:
        mostrar_arreglo(arrayN[::-1])
    
def quick_sort_auxiliar(arrayN, inicio, fin):
    if inicio < fin:
        punto_particion = particionar(arrayN, inicio, fin)

        quick_sort_auxiliar(arrayN, inicio, punto_particion - 1)
        quick_sort_auxiliar(arrayN, punto_particion + 1, fin)
    

def particionar(arrayN, inicio, fin):
    pivote = arrayN[inicio]
    izquierda = inicio + 1
    derecha = fin
    terminado = False
    while not terminado:
        while izquierda <= derecha and arrayN[izquierda] <= pivote:
            izquierda += 1

        while arrayN[derecha] >= pivote and derecha >= izquierda:
            derecha -= 1

        if derecha < izquierda:
                terminado = True
        else:
            arrayN[izquierda], arrayN[derecha] = arrayN[derecha], arrayN[izquierda]
    arrayN[inicio], arrayN[derecha] = arrayN[derecha], arrayN[inicio]
    return derecha


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

    print("---------QUICKSORT----------")
    print("---------ASC----------")
    quick_sort(arrayN,0)
    print("---------DESC----------")
    quick_sort(arrayN,1)

leer_arreglo()
