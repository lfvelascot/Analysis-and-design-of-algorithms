def mergeSort(lista):
    if len(lista) <= 1:
        return lista

    medio = len(lista) / 2
    izquierda = lista[:medio]
    derecha = lista[medio:]

    izquierda = mergeSort(izquierda)
    derecha = mergeSort(derecha)

    return merge(izquierda, derecha)

def merge(listaA, listaB):
    lista_nueva = []
    a = 0
    b = 0

    while a < len(listaA) and b < len(listaB):
        comparaciones += 1

        if listaA[a] < listaB[b]:
            lista_nueva.append(listaA[a])
            a += 1
        else:
            lista_nueva.append(listaB[b])
            b += 1

    while a < len(listaA):
        lista_nueva.append(listaA[a])
        a += 1

    while b < len(listaB):
        lista_nueva.append(listaB[b])
        b += 1

    return lista_nueva

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
A= mergeSort(A,len(A))
imprimeLista(A,len(A))