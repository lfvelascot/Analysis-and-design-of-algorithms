class Pila:
    """ Representa una pila con operaciones de apilar, desapilar y
        verificar si está vacía. """

    def __init__(self):
        """ Crea una pila vacía. """
        # La pila vacía se representa con una lista vacía
        self.items=[]

    def push(self, x):
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

class Cola:


    def __init__(self):
        self.items=[]

    def encolar(self, x):
        self.items.append(x)

    def desencolar(self):
        try:
            return self.items.pop(0)
        except:
            raise ValueError("La cola está vacía")

    def es_vacia(self):
        return self.items == []

class ArbolBinarioOrdenado:
    
    def __init__(self):
        """constructor, los atributos no son privados"""
        self.raiz=None
        self.arbolIzdo=None
        self.arbolDcho=None
        
        
    def raiz(self):
        """Operacción de consulta: funcion que devuelve la raiz"""
        return self.raiz
    
   
    def arbolIzdo(self):
        """Operación de consulta: devuelve el subarbol izquierdo"""
        return self.arbolIzdo
    
    def arbolDcho(self):
        """Operación de consulta: devuelve el subarbol derecho"""
        return self.arbolDcho   
    
    def estaVacio(self):
        """Operación de consulta: devuelve el subarbol derecho"""
        return self.raiz==None
    
    def insertarElem(self,elemento):
        """Operación de inserción, se inserta el elemento  de forma ordenada"""
        try:  
            if self.estaVacio():
                self.raiz=elemento
                self.arbolIzdo=ArbolBinarioOrdenado()
                self.arbolDcho=ArbolBinarioOrdenado()
            elif elemento<=self.raiz:
                self.arbolIzdo.insertarElem(elemento)
            elif elemento>self.raiz:
                self.arbolDcho.insertarElem(elemento)
            else:
                None
        except TypeError:
               print('el siguiente elemento no es correcto para el tipo de datos manejado:'+elemento)
            
                
    def tieneElemento(self,elemento):
        """Operación de consulta: Comprueba si existe un  elemento en el árbol"""

        if self.estaVacio():
            return False
        elif self.raiz==elemento:
            return elemento#True
        elif elemento<self.raiz:
            return self.arbolIzdo.tieneElemento(elemento)
        else:
            return self.arbolDcho.tieneElemento(elemento)
        
        
    def numElementos(self):
        """Operación de consulta: Devuelve el númerro de elementos que hay en el árbol"""
        if self.estaVacio():
            return 0
        else:
            return 1+self.arbolIzdo.numElementos()+self.arbolDcho.numElementos()
               
    def eliminarArbol(self):
        """Operación de eliminación"""
        if not self.estaVacio():
            self.arbolIzdo.eliminarArbol()
            self.arbolDcho.eliminarArbol()
            self.raiz=None
               
    def inOrden(self):
        """Recorrido en inorden, hijo izdo, raiz, hijo derecho"""
        l=[]
        if not self.arbolIzdo.estaVacio():
            l+=self.arbolIzdo.inOrden()
        l.append(self.raiz)
        if not self.arbolDcho.estaVacio():
            l+=self.arbolDcho.inOrden()
        return l
    
    
    'Función de busqueda Pre-orden implementada de manera adicional al algoritmo entregado en clase de Tema 4'
    
    def PreOrden(self):
        """"Recorrido en Preorden, raiz, hijo izquierdo, hijo derecho"""
        l = []
        l.append(self.raiz)
        if not self.arbolIzdo.estaVacio():
            l+=self.arbolIzdo.PreOrden()
        if not self.arbolDcho.estaVacio():
            l+=self.arbolDcho.PreOrden()
        return l

    def PostOrden(self):
        """"Recorrido en PostOrden, raiz, hijo izquierdo, hijo derecho"""
        l = []
        if not self.arbolIzdo.estaVacio():
            l+=self.arbolIzdo.PostOrden()
        if not self.arbolDcho.estaVacio():
            l+=self.arbolDcho.PostOrden()
        l.append(self.raiz)
        return l

    
    
    def numHijos(self):
        if not self.arbolIzdo.estaVacio() and not self.arbolDcho.estaVacio():
            return 2
        else:
            return 1   
    
    def noTieneHijos(self):
        """Comprueba si no  tiene hijos"""
        return self.__arbolIzdo.estaVacio() and self.__arbolDcho.estaVacio()

    
    def hijoUnico(self):
        """Devuelve el hijo único de un nodo que sólo tiene un hijo"""
        return self.arbolIzdo if self.arbolDcho.estaVacio() else self.arbolDcho
    
    
    def obtenerMasIzda(self,padre):
        """Obtiene el hijo más a la izquierda de un nodo"""
        
        if not self.arbolIzdo.estaVacio():
            
            return self.arbolIzdo.obtenerMasIzda(self.arbolIzdo)

        return [self,padre]

        
    
    
    def eliminarRaizConDosHijos(self):
        """Elimina un nodo con  dos hijos"""
       
        aux=self.__arbolDcho.obtenerMasIzda(self)
       
        
        if not aux[0].estaVacio():
            
            self.raiz=aux[0].raiz
            
            aux[0].eliminarElem(aux[0].raiz,aux[1])
            
    
    def eliminarElem(self,elemento,padre=None):
        """Funcion que elimina  un elemento de un árbol"""
        if not self.estaVacio():
            
            if self.raiz==elemento:
              
                if self.noTieneHijos():
                   
                    if padre==None:
                        self.raiz=None
                    elif  padre.arbolIzdo.raiz==elemento:
                        padre.arbolIzdo.raiz=None
                    else:
                        padre.arbolDcho.raiz=None
                elif self.numHijos()==1:
                     
                     
                    if padre.arbolIzdo.raiz==elemento:
                        
                         padre.arbolIzdo=self.hijoUnico()
                    else:
                       
                        padre.arbolDcho=self.hijoUnico()
                    
                else:
                    
                    self.eliminarRaizConDosHijos()
            elif self.raiz>elemento:
                self.arbolIzdo.eliminarElem(elemento,self)
            else:
                self.arbolDcho.eliminarElem(elemento,self)
                
                
        """Operación de consulta: Extrae el valor de la raíz ingresada al árbol""" 
    
    def consultaRaiz(self):
        
        if self.estaVacio():
            return False
        else:
            return self.raiz
        
        """Operación de consulta recursiva: Extrae el hijo izquierdo de un nodo""" 
    
    def hijoIzdo(self,elemento):
        if self.tieneElemento(elemento) == False:
            print('Elemento no presente en el árbol binario')
        else:
            if self.raiz == elemento:
                return self.arbolIzdo.raiz
            if elemento<self.raiz:
                return self.arbolIzdo.hijoIzdo(elemento)
            else:
                return self.arbolDcho.hijoIzdo(elemento)

       
        """Operación de consulta recursiva: Extrae el hijo derecho de un nodo""" 
    
    def hijoDcho(self,elemento):
        if self.raiz == elemento:
            return self.arbolDcho.raiz
        if elemento>self.raiz:
            return self.arbolDcho.hijoDcho(elemento)
        else:
            return self.arbolIzdo.hijoDcho(elemento)
        
#### Codigo Tutor
    def IterInorden(self):
        p = Pila()
        lista = []
        actual = self
        while actual is not None or p.isEmpty() is False:
            while actual is not None:
                p.push(actual) 
                actual = actual.arbolIzdo
            if actual is None and p.isEmpty() is False:
                temp = p.pop()
                if temp.raiz is not None:
                	lista.append(temp.raiz)
                actual=temp.arbolDcho
        return lista;

    def IterPreOrden(self):
        l = []
        pila = Pila()
        actual = self
        while actual is not None or pila.isEmpty() is False:
        	while actual is not None:
        		pila.push(actual)
        		if actual.raiz is not None:
        			l.append(actual.raiz)
        		actual = actual.arbolIzdo
        	actual = pila.pop()
        	actual = actual.arbolDcho
        return l


    def IterPostOrden(self):
    	l = []
    	pila = Pila()
    	if self.raiz is None:
    		return l
    	pila.push(self)
    	while pila.isEmpty() is False:
    		actual = pila.pop()
    		if actual.arbolIzdo is not None:
    			pila.push(actual.arbolIzdo)
    		if actual.arbolDcho is not None:
    			pila.push(actual.arbolDcho)
    		if actual.raiz is not None:
    			l.append(actual.raiz)
    	return l[::-1]

    def recorridoAmplitud (self):
        cola = Cola()
        l = []
        aux = self
        if self.raiz is not None:
            cola.encolar(self)
            while cola.es_vacia() is False:
                aux = cola.desencolar()
                if aux.raiz is not None:
                    l.append(aux.raiz)
                if aux.arbolIzdo is not None:
                    cola.encolar(aux.arbolIzdo)
                if aux.arbolDcho is not None:
                    cola.encolar(aux.arbolDcho) 
        return l

    def IterAmplitud(self):
        l = []
        cola = Cola()
        actual  = self
        cola.encolar(actual)
        while actual is not None or cola.es_vacia() is False:
            aux = cola.desencolar()
            if aux.arbolIzdo is not None:
                actual = aux.arbolIzdo
                cola.encolar(actual.raiz)
            if aux.arbolDcho is not None:
                actual = aux.arbolDcho
                cola.encolar(actual.raiz)
            l.append(cola.desencolar())

        return l


arbol_prueba=ArbolBinarioOrdenado()
arbol_prueba.insertarElem(15)
arbol_prueba.insertarElem(9)
arbol_prueba.insertarElem(20)
arbol_prueba.insertarElem(6)
arbol_prueba.insertarElem(14)
arbol_prueba.insertarElem(13)
arbol_prueba.insertarElem(17)
arbol_prueba.insertarElem(64)
arbol_prueba.insertarElem(26)
arbol_prueba.insertarElem(72)
print('El arbol es')
print("PreOrden Recursivo")
print(arbol_prueba.PreOrden())
print("PreOrden Iterativo")
print(arbol_prueba.IterPreOrden()) 
print("Inorden Recursivo")
print(arbol_prueba.inOrden())
print("Inorden Iterativo")
print(arbol_prueba.IterInorden())
print("PostOrden Recursivo")
print (arbol_prueba.PostOrden())
print("PostOrden Iterativo")
print(arbol_prueba.IterPostOrden())
print("Recorrido por amplitud (T)")
print(arbol_prueba.recorridoAmplitud())
print("Recorrido por amplitud")
print(arbol_prueba.IterAmplitud())
