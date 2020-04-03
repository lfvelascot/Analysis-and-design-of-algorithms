# Analysis and design of algorithms

[![USSBOG](data:image/jpeg;base64,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)](https://www.usbbog.edu.co/)

Repository of the class of Analysis and design of algorithms, where the projects and other activities carried out in class such as the following will be:
  - Projects
  - Marathon exercises
  - Algorithms of matter

### Made by: Luis Felipe Velasco Tao
| Activities |                       Description                     |
| ------ | ------ |
| Exercise log |Contains all the exercises done related to programming marathons, exercises done in java or python with flow diagrams and pseudo code.Here you can find the executables (.java) and the document where the statements, flow diagrams, equations and pseudocode of each of the exercises are found in the document "ExerciseLog.docx". [Click here to see to the document.](https://github.com/lfvelascot/Analysis-and-design-of-algorithms/tree/master/Sorting%20Methods)  --- [Click here to go to the folder.](https://github.com/lfvelascot/Analysis-and-design-of-algorithms/tree/master/exerciseLog/src/anlisisAlgoritmos/sis/ing/usbbog/edu/co)    [![UrIOnline ](https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSIG0ETU2saYktROJsfEJvPuhcWEyvsWu1UFtSyajGTKsPK7RQC&usqp=CAU)](https://www.urionlinejudge.com.br/judge/en/login)|
| Python log |Log of the python course module 1, where all the basic python concepts, python structures, object-oriented programming and graphical interface are explained. Click on the following image to see the course that took place at pildorasinformaticas.es [![Python](https://www.redeszone.net/app/uploads/2018/07/C%C3%B3digo-Python.jpg)](https://www.pildorasinformaticas.es/course/curso-python/)|
| Algorithm classification | Workshop where all types of algorithms and examples of use of each one are shown. Here you can find the document that explains and gives examples of each of the types of algorithms, and the executables with the algorithms made in Java. [Click here to see the document](https://github.com/lfvelascot/Analysis-and-design-of-algorithms/blob/master/Algorithmsclassification.docx) --- [Click here to go to the folder.](https://github.com/lfvelascot/Analysis-and-design-of-algorithms/tree/master/algorithmClassification/src/analisisAlgoritmos/sis/ing/usbbog/edu/co) ![algoritmos](https://diwo.bq.com/wp-content/uploads/2015/09/Destacados-pepe.jpg)|
| Sorting algorithms in Python | Contains the recursive and / or iterative sorting algorithms developed in Python. [Click here to go to the folder.](https://github.com/lfvelascot/Analysis-and-design-of-algorithms/tree/master/Sorting%20Methods) ![algoritmos ordenamiento](https://users.dcc.uchile.cl/~lmateu/CC10A/Apuntes/ordenamiento/seleccion.gif)|
| Coronavirus Project| Program for the management of the data related to the Covid-19 of each of the countries, in this program the number of infected and dead by country is managed, in addition to showing the total of each of the stored data, and the date updating the data. [Click here to go to the project.](https://github.com/lfvelascot/Analysis-and-design-of-algorithms/tree/master/CoronaVirus) |
| Demonstration video of the Coronavirus program:| The following URL could find a link where the project carried out by the coronavirus, used items and a demonstration of the program created is explained. [click here to see the video](https://youtu.be/StH7JTbrZTY) [![](https://raw.githubusercontent.com/lfvelascot/Analysis-and-design-of-algorithms/master/Miniatura.PNG)](https://youtu.be/StH7JTbrZTY) |

##### Made by: Luis Felipe Velasco Tao

