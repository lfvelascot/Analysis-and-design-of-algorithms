import six
#############################
# Definir una clase de nodo huffman
#############################
class Node:
    def __init__(self,freq):
        self.left = None
        self.right = None
        self.father = None
        self.freq = freq
 
    def is_left(self):
        return self.father.left == self

#############################
##Función de generación de nodos
#############################
def create_nodes(frequencies):
    return [Node(freq) for freq in frequencies]

#############################
#huffmanFunción de generación de árboles
#############################
def create_huffman_tree(nodes):
    queue = nodes[:]
    while len(queue) > 1:
        queue.sort(key=lambda item: item.freq)
        node_left = queue.pop(0)
        node_right = queue.pop(0)
        node_father = Node(node_left.freq + node_right.freq)
        node_father.left = node_left
        node_father.right = node_right
        node_left.father = node_father
        node_right.father = node_father
        queue.append(node_father)
    queue[0].father = None
    return queue[0]

###############################
#Generar código huffman según árbol huffman
###############################
def huffman_encoding(nodes, root):
    codes = [''] * len(nodes)
    for i in range(len(nodes)):
        node_tmp = nodes[i]
        while node_tmp != root:
            if node_tmp.is_left():
                codes[i] = '0' + codes[i]
            else:
                codes[i] = '1' + codes[i]
            node_tmp = node_tmp.father
    print("Texto codificado: ",codes)        
    return codes

#############################################
# Obtener la frecuencia de los caracteres
#############################################
def count_frequency(input_string):
    # Se usa para almacenar personajes
    char_store = []
    # Se usa para almacenar frecuencia
    freq_store = []
 
    # Analizar cadena
    for index in range(len(input_string)):
        if char_store.count(input_string[index]) > 0:
            temp = int(freq_store[char_store.index(input_string[index])])
            temp = temp + 1
            freq_store[char_store.index(input_string[index])] = temp
        else:
            char_store.append(input_string[index])
            freq_store.append(1)
    # Regresar a la lista de personajes y frecuencia
    print("Frecuencia de cada caracter:")
    print (char_store)
    print (freq_store)
    return char_store, freq_store

############################
# Obtenga una lista de caracteres y frecuencias
############################
    
def get_char_frequency(char_store=[], freq_store=[]):
    # Se usa para almacenar char_frequency
    char_frequency = []
    for item in zip(char_store, freq_store):
        temp = (item[0], item[1])
        char_frequency.append(temp)
    return char_frequency

################################
#Conversión de #Coding
################################
def write_file(code):
    f=open("huffman_encoding.txt","wb")
    out=0
    while len(code)>8:
        for x in range(8):
            out=out<<1
            if code[x]=="1":
                out=out|1
        code=code[8:]
        f.write(six.int2byte(out))
        out=0

    f.write(six.int2byte(len(code)))
    out=0
    for i in range(len(code)):
        out=out<<1
        if code[i]=="1":
            out=out|1
    
    for i in range(8-len(code)):
        out=out<<1
    f.write(six.int2byte(out))
    f.close()
    return True

def read_file(code):
    f=open("huffman_encoding.txt","wb")
    out=0
    while len(code)>8:
        for x in range(8):
            out=out<<1
            if code[x]=="1":
                out=out|1
        code=code[8:]
        f.read(six.int2byte(out))
        out=0

    f.write(six.int2byte(len(code)))
    out=0
    for i in range(len(code)):
        out=out<<1
        if code[i]=="1":
            out=out|1
    
    for i in range(8-len(code)):
        out=out<<1
    f.read(six.int2byte(out))
    f.close()
    return True


###############################
# Convertir caracteres a codificación huffman
###############################
def get_huffman_file(input_string, char_frequency, codes):
    # Reemplazar carácter por carácter
    file_content = ''
    for index in range(len(input_string)):
        for item in zip(char_frequency, codes):
            if input_string[index] == item[0][0]:
                file_content = file_content + item[1]
    print("Contenido del archivo: ",file_content)

    return file_content


##################################
#Descodificación de archivos codificados por huffman
###################################
def decode_huffman(input_string,  char_store, freq_store):
    encode = ''
    decode = ''
    for index in range(len(input_string)):
        encode = encode + input_string[index]
        for item in zip(char_store, freq_store):
            if encode == item[1]:
                decode = decode + item[0]
                encode = ''
    print("Contenido del archivo decodificado: ",decode)            
    return decode


fo=open("text.txt","r+")# Lee el archivo a comprimir
input_string=fo.read()
print("VALOR ALMACENADO EN EL TXT: ",input_string)
fo.close()
char_store, freq_store=count_frequency(input_string)# Estadísticas de apariciones de cartas
char_frequency=get_char_frequency(char_store,freq_store)# Estadísticas de banda
nodes=create_nodes([i[1] for i in char_frequency])# Generación de nodos
root= create_huffman_tree(nodes)# Marcar el nodo raíz
codes=huffman_encoding(nodes,root)#Generar árbol huffman
save_file=get_huffman_file(input_string,char_frequency,codes)# De acuerdo con el árbol de huffman generado, genera código de huffman
write_file(save_file)#Escribe la cadena de 01 bit en el archivo bit a bit


