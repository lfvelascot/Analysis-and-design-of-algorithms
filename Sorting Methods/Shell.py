def shell(arrayN):
    mitad = len(arrayN) // 2

    while mitad > 0:
        for p in range(mitad):
            reducir(arrayN, p, mitad)

        mitad = mitad // 2

    mostrar_arreglo(arrayN)

def reducir(arrayN, inicio, salto):
    for i in range(inicio + salto, len(arrayN), salto):
        valor = arrayN[i]
        posicion = i

        while posicion >= salto and arrayN[posicion - salto] < valor:
            arrayN[posicion] = arrayN[posicion - salto]
            posicion = posicion - salto

        arrayN[posicion] = valor

def shell_inverso(arrayN):
    mitad = len(arrayN) // 2

    while mitad > 0:
        for p in range(mitad):
            reducir_inverso(arrayN, p, mitad)

        mitad = mitad // 2

    mostrar_arreglo(arrayN)

def reducir_inverso(arrayN, inicio, salto):
    for i in range(inicio + salto, len(arrayN), salto):
        valor = arrayN[i]
        posicion = i

        while posicion >= salto and arrayN[posicion - salto] > valor:
            arrayN[posicion] = arrayN[posicion - salto]
            posicion = posicion - salto

        arrayN[posicion] = valor

def mostrar_arreglo(arrayN):
    for i in range(len(arrayN)):
        print('Elemento '+'-------> '+str(arrayN[i]))


def leer_arreglo():
    longitud = int(input("¿De que tamaña seria?"))
    arrayN = [0]*longitud
    index = 0
    for iten in arrayN:
        arrayN[index] = int(input("Digite el numero "+str(index)+" del arreglo: "))
        index = index + 1

    print("-------------SHELL------------")
    print("-------------ASC--------------")
    shell_inverso(arrayN)
    print("-------------DESC-------------")
    shell(arrayN)
    

leer_arreglo()
