def insercionBinaria(lista,tam):
    for i in range(1,tam):
        aux=lista[i]
        izq=0
        der=i-1
        while izq<=der:
                m=int((izq+der)/2)
                if aux < lista[m]:
                        der=m-1
                else:
                        izq=m+1
 
        j=i-1
        while j>=izq:
                lista[j+1]=lista[j]
                j=j-1
        lista[izq]=aux
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
A= insercionBinaria(A,len(A))
imprimeLista(A,len(A))