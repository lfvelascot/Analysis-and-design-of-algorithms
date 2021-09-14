def insercionDirecta(lista,tam):
    for i in range(1,tam):
        v=lista[i]
        j=i-1
        while j >= 0 and lista[j] > v:
            lista[j+1] = lista[j]
            j=j-1
        lista[j+1]=v
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
A= insercionDirecta(A,len(A))
imprimeLista(A,len(A))