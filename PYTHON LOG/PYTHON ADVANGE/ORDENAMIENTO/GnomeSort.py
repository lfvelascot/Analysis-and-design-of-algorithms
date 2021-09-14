def Gnome_sort(vector):
    i_b,i_i,taille = 1,2,len(vector)
    while i_b < taille:
        if vector[i_b-1] <= vector[i_b]:
            i_b,i_i = i_i, i_i+1
        else:
            vector[i_b-1],vector[i_b] = vector[i_b],vector[i_b-1]
            i_b -= 1
            if i_b == 0:
                i_b,i_i = i_i, i_i+1
    return vector

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
A= Gnome_sort(A)
imprimeLista(A,len(A))