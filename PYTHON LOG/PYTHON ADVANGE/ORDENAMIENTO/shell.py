def ordenShell(lista,tam):
    inc=1
    for inc in range(1,tam,inc*3+1):
        while inc>0:
            for i in range(inc,tam):
                j=i
                temp=lista[i]
                while j>=inc and lista[j-inc]>temp:
                    lista[j]=lista[j-inc]
                    j=j-inc
                lista[j]=temp
            inc=int(inc/2)
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
A= ordenShell(A,len(A))
imprimeLista(A,len(A))