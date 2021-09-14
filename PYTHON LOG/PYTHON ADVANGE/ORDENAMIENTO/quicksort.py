def quicksort(L, first, last):
    # definimos los índices y calculamos el pivote
    i = first
    j = last    
    pivote = int((L[i] + L[j]) / 2)
    while i < j:
        while L[i] < pivote:
            i+=1
        while L[j] > pivote:
            j-=1
        if i <= j:
            x = L[j]
            L[j] = L[i]
            L[i] = x
            i+=1
            j-=1
    if first < j:
        L = quicksort(L, first, j)
    if last > i:
        L = quicksort(L, i, last)

    return L
 
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
A= quicksort(A,0,len(A)-1)
imprimeLista(A,len(A))