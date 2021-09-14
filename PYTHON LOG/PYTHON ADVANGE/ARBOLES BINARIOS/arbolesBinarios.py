class Pila:
    """ Representa una pila con operaciones de apilar, desapilar y
        verificar si está vacía. """

    def __init__(self):
        """ Crea una pila vacía. """
        # La pila vacía se representa con una lista vacía
        self.items=[]

    def push(self, x):
        """ Agrega el elemento x a la pila. """
        # Apilar es agregar al final de la lista.
        self.items.append(x)

    def pop(self):
        """ Devuelve el elemento tope y lo elimina de la pila.
        Si la pila está vacía levanta una excepción. """
        try:
            return self.items.pop()
        except IndexError:
            raise ValueError("La pila está vacía")

    def isEmpty(self):
        """ Devuelve True si la lista está vacía, False si no. """
        return self.items == []

class Nodo:
    def __init__(self, dato):
        self.dato = dato
        self.izquierda = None
        self.derecha = None

class Arbol:

    def __init__(self, dato):
        self.raiz = Nodo(dato)

    def __agregar_recursivo(self, nodo, dato):
        if dato < nodo.dato:
            if nodo.izquierda is None:
                nodo.izquierda = Nodo(dato)
            else:
                self.__agregar_recursivo(nodo.izquierda, dato)
        else:
            if nodo.derecha is None:
                nodo.derecha = Nodo(dato)
            else:
                self.__agregar_recursivo(nodo.derecha, dato)

    def __inorden_recursivo(self, nodo):
        if nodo is not None:
            self.__inorden_recursivo(nodo.izquierda)
            print(nodo.dato, end=", ")
            self.__inorden_recursivo(nodo.derecha)

    def __preorden_recursivo(self, nodo):
        if nodo is not None:
            print(nodo.dato, end=", ")
            self.__preorden_recursivo(nodo.izquierda)
            self.__preorden_recursivo(nodo.derecha)

    def __inorden(self):
        p = Pila()
        lista = []
        actual = self.raiz
        while actual is not None or p.isEmpty() is False:
            while actual is not None:
                p.push(actual)
                actual = actual.izquierda
            if actual is None and p.isEmpty() is False:
                temp = p.pop()
                lista.append(temp.dato)
                actual=temp.derecha
        print(lista)
        


    def __postorden_recursivo(self, nodo):
        if nodo is not None:
            self.__postorden_recursivo(nodo.izquierda)
            self.__postorden_recursivo(nodo.derecha)
            print(nodo.dato, end=", ")

    def __postorden(self):
        l = []
        pila = Pila()
        if self.raiz is None: return l
        pila.push(self.raiz)
        while pila.isEmpty() is False:
            actual = pila.pop()
            l.append(actual.dato)
            if actual.izquierda is not None:
                pila.push(actual.izquierda)
            if actual.derecha is not None:
                pila.push(actual.derecha)  
        return l[::-1]

    def __buscar(self, nodo, busqueda):
        if nodo is None:
            return None
        if nodo.dato == busqueda:
            return nodo
        if busqueda < nodo.dato:
            return self.__buscar(nodo.izquierda, busqueda)
        else:
            return self.__buscar(nodo.derecha, busqueda)


    def agregar(self, dato):
        self.__agregar_recursivo(self.raiz, dato)

    def inorden(self):
        print("Imprimiendo árbol inorden: ")
        self.__inorden_recursivo(self.raiz)
        print("")

    def preorden(self):
        print("Imprimiendo árbol preorden: ")
        self.__preorden_recursivo(self.raiz)
        print("")

    def indorden2(self):
        print("Imprimiendo árbol indorden iterativo: ")
        self.__inorden()
        print("")

    def postorden2(self):
        print("Imprimiendo árbol postorden iterativo: ")
        print(self.__postorden())
        print("")

    def postorden(self):
        print("Imprimiendo árbol postorden: ")
        self.__postorden_recursivo(self.raiz)
        print("")

    def buscar(self, busqueda):
        return self.__buscar(self.raiz, busqueda)

arbol_numeros = Arbol(15)
arbol_numeros.agregar(9)
arbol_numeros.agregar(6)
arbol_numeros.agregar(14)
arbol_numeros.agregar(13)
arbol_numeros.agregar(20)
arbol_numeros.agregar(17)
arbol_numeros.agregar(64)
arbol_numeros.agregar(26)
arbol_numeros.agregar(72)

arbol_numeros.inorden()
##arbol_numeros.indorden2()
arbol_numeros.preorden()
arbol_numeros.postorden()
arbol_numeros.postorden2()

#busqueda = int(input("Ingresa un número para buscar en el árbol: "))
#n = arbol_numeros.buscar(busqueda)
#if n is None:
#    print(f"{busqueda} no existe")
#else:
#    print(f"{busqueda} sí existe")