def selectionSort(lista,tam):
    for i in range(0,tam-1):
        min=i
        for j in range(i+1,tam):
            if lista[min] > lista[j]:
                min=j
        aux=lista[min]
        lista[min]=lista[i]
        lista[i]=aux
    return lista

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
A= selectionSort(A,len(A))
imprimeLista(A,len(A))