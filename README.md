

# Proyecto Operación Fuego de Quasar:


Se deja en la raiz del proyecto la collection postman del proyecto challengeML.postman_collection.json

aws url host http://rebelallianceaws-env.eba-g3dftm3m.us-east-1.elasticbeanstalk.com


Pasos para levantar el proyecto:

Se requiere tener java 11 y maven

1- Correr mvn clean install en la raíz del proyecto

2- Correr mvn spring-boot:run  en la raíz del proyecto

Notas

***************************************************

Enunciado:

Crear un programa con las siguientes firmas:
// input: distancia al emisor tal cual se recibe en cada satélite
// output: las coordenadas ‘x’ e ‘y’ del emisor del mensaje
func GetLocation(distances ...float32) (x, y float32)

Aclaracion:

Para este punto se intento realizar un algoritmo basado en la Trilateración, 
debido a la falta de practica en este tipo de problemas no llegue a una solucion.

Opte por integrar la siguiente libreria https://github.com/lemmingapex/trilateration

****************************************************

Enunciado:

// input: el mensaje tal cual es recibido en cada satélite
// output: el mensaje tal cual lo genera el emisor del mensaje
func GetMessage(messages ...[]string) (msg string)

Duda:
En el siguiente punto no me quedo claro el desfasaje si era el largo de los 3 arrays podria variar o 
podria haber string vacios en lugares que no correspondiera.
Se opto por considerar correcto que varie el largo de los arrays para llegar a generar el msj final

● Considerar que existe un desfasaje (a determinar) en el mensaje que se recibe en cada satélite.
  
  ○ Ejemplo:
    ■ Kenobi: [“”, “este”, “es”, “un”, “mensaje”] 
    ■ Skywalker: [“este”, “”, “un”, “mensaje”]
    ■ Sato: [“”, ””, ”es”, ””, ”mensaje”]

