def mostrar_arreglo(arrayN):
    for i in range(len(arrayN)):
        print('Elemento '+'-------> '+str(arrayN[i]))

def ordenamientoPorInsercion(arrayN,opc):
   if (opc == 0):
         for indice in range(1,len(arrayN)):
            valorActual = arrayN[indice]
            posicion = indice

            while posicion>0 and arrayN[posicion-1]<valorActual:
               arrayN[posicion]=arrayN[posicion-1]
               posicion = posicion-1
            arrayN[posicion]=valorActual
   else :
         for indice in range(1,len(arrayN)):
            valorActual = arrayN[indice]
            posicion = indice
            while posicion>0 and arrayN[posicion-1]>valorActual:
               arrayN[posicion]=arrayN[posicion-1]
               posicion = posicion-1
            arrayN[posicion]=valorActual
   mostrar_arreglo(arrayN)

def leer_arreglo():
    longitud = int(input("Tamaño del arreglo -------> "))
    arrayN = [0]*longitud
    index = 0
    for iten in arrayN:
       arrayN[index] = int(input("Digite el numero "+str(index)+" del arreglo: "))
       index = index + 1
    print("---------Insercion-------------")
    print("---------DESC------------------")
    ordenamientoPorInsercion(arrayN,0)
    print("---------ASC-------------------")
    ordenamientoPorInsercion(arrayN,1)

leer_arreglo()
