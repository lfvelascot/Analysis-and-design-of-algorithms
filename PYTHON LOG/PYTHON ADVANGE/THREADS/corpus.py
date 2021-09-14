# -*- coding: utf-8 -*-
"""
Created on Sat Jun 19 16:32:08 2021

@author: cgotalorav
"""

import pandas as pd
import multiprocessing as mp
import numpy as np
import time

#modulo para usar expresiones regulares
import re
from multiprocessing import Pool
#importación del corpus brown
from nltk.corpus import brown
#funcion que construye el DataFrame para su procesamiento, on una frase por fila
def construye_textos():
    return [" ".join(np.random.permutation(sents)) for sents in brown.sents()]
    #Genera la lista con la unión de los elementos separados por un espacio en una sola "línea"
    
#funcion que reemplaza comillas dobles
def reemplazar_comillas(texto):
    return texto.apply(lambda text: text.replace("``",'"'))

#funcion que convierte todas las palabras a minúsculas
#la función que pasa a minusculas es text.lower()
def a_minusculas(texto):
    return texto.apply(lambda text: text.Lower())

#funcion que cuenta palabras de cada fila del dataframae
#separa las palabras en el texto de cada fila con split y devuelve la longitud de la lista de palabras
#la función que devuelve la lista de palabras es re.split(r"(?:\s+)|(?:,)|(?:\-)",text)
def contar_palabras(texto):
    text = texto['text'].str
    x = re.split(r"(?:\s+)|(?:,)|(?:\-)",text)
    a = len(x)
    return a
#funcion que se aplica


def procesar_df(df):
  #se hace copia del dataframe para no modificarlo
  ###INSERTA TU CODIGO###
      salida_df = df.copy(deep=True)
    

  # reemplaza las comillas
    salida_df['text'] = reemplazar_comillas(salida_df['text'])

  # pasa el texto a minusculas 
    salida_df['text'] = a_minusculas(salida_df['text'])

  # elimina los textos demasiado largos
    texto_largo_para_eliminar = salida_df[salida_df['num_palabras'] > 50]
    salida_df.drop(texto_largo_para_eliminar.index, inplace=True)

  # elimina los textos demasiado cortos
    texto_corto_para_eliminar = salida_df[salida_df['num_palabras'] < 10]
    salida_df.drop(texto_corto_para_eliminar.index, inplace=True)    

 #cuenta el número de palabras y construye columna nueva con nombre num_palabras
    num = contar_palabras(salida_df['text'])
    salida_df.assign(num_palabras = num)
    
  #reinicializa los indices
    salida_df.reset_index(drop=True, inplace=True)

    return salida_df

def procesar_df_p(df):
  #se hace copia del dataframe para no modificarlo
  ###INSERTA TU CODIGO###
    salida_df = df.copy(deep=True)
    

  # reemplaza las comillas
    salida_df['text'] = reemplazar_comillas(salida_df['text'])

  # pasa el texto a minusculas 
    salida_df['text'] = a_minusculas(salida_df['text'])

  # elimina los textos demasiado largos
    texto_largo_para_eliminar = salida_df[salida_df['num_palabras'] > 50]
    salida_df.drop(texto_largo_para_eliminar.index, inplace=True)

  # elimina los textos demasiado cortos
    texto_corto_para_eliminar = salida_df[salida_df['num_palabras'] < 10]
    salida_df.drop(texto_corto_para_eliminar.index, inplace=True)    
  
  #reinicializa los indices
    salida_df.reset_index(drop=True, inplace=True)

    return salida_df

def contar_p(df)
    #se hace copia del dataframe para no modificarlo
    ###INSERTA TU CODIGO###
    salida_df = df.copy(deep=True)
    #cuenta el número de palabras y construye columna nueva con nombre num_palabras
    num = contar_palabras(salida_df['text'])
    salida_df.assign(num_palabras = num)
return salida_df
if __name__=="__main__":
    
    dataframe_brown = pd.DataFrame({
    'text': construye_textos() + construye_textos() + construye_textos() + construye_textos()
    })
    print(dataframe_brown)
    
    start_time = time.time()
    print("inicio --- %h, m, s ---" % start_time)
           
    """ejecución secuencial"""
    df_procesado = procesar_df(dataframe_brown)
    
    print(df_procesado)
    
    end_time = time.time()
    print("finalización--- %h, m, s ---" % end_time)
    
    print("Tiempo total --- %s segundos ---" % (end_time - start_time))
    
      
    #muestra fila 0
    print(df_procesado.loc()[0])
    
    #retorna el numero de núcleos en el sistema, te puede servir para decidir el número de procesos
    n_nucleos = mp.cpu_count()
    print(n_nucleos)
    
    """ejecución paralela"""
    #divide en trozos el dataframe, decide el numero de trozos y haz comparaciones de rendimientos
    trozos_df = np.array_split(dataframe_brown,3)
    df_1 = pd.Dataframe({'text':trozos_df[0]})
    df_2 = pd.Dataframe({'text':trozos_df[1]})
    df_3 = pd.Dataframe({'text':trozos_df[2]})
    
    # se  toma tiempo inicial
    start_time = time.time()
    print("inicio --- %h, m, s ---" % start_time)
    
    #se crea el pool de procesos, decide cuantos procesos crear
    with Pool(n_nucleos) as p:
        proceso1 = p.map(procesar_df_p, df_1)
        proceso2 = p.map(procesar_df_p, df_1)
        proceso3 = p.map(procesar_df_p, df_1)
    
    #se invoca a la función y se concatenan los resultados de cada trozo con pd.concat(resultados del map)
    df_concat = pd.concat([proceso1,proceso2,proceso3])
    df_concat=contar_p(df_concat)
    
    end_time = time.time()
    print("finalización--- %h, m, s ---" % end_time)
    
    print("Tiempo total --- %s segundos ---" % (end_time - start_time))   
    
    # se muestra la fila 0
    print(df_concat)
    print(df_concat.loc()[0])