from heapq import heappop, heappush

def heap_sort(array):
    heap = []
    for element in array:
        heappush(heap, element)

    ordered = []
    while heap:
        ordered.append(heappop(heap))
    return ordered
 
def imprimeLista(lista,tam):
    for i in range(0,tam):
        print (lista[i])
 
def leeLista():
    lista=[]
    cn=int(input("Cantidad de numeros a ingresar: "))
 
    for i in range(0,cn):
        lista.append(int(input("Ingrese numero %d : " % i)))
    return lista

A=leeLista()
A= heap_sort(A)
imprimeLista(A,len(A))