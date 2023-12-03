# Hotel de los Andes con MongoDB 

Este proyecto busca resolver lo requerido para el proyecto 3 NO SQL de Sistemas Transaccionales

## Contenido

1. [Requisitos](#requisitos)
2. [Conexion del proyecto a la base de datos](#conexion-del-proyecto-a-la-base-de-datos)
3. [Colecciones](#colecciones)
4. [Tecnologias usadas](#tecnologias-usadas)
5. [Colaboración](#colaboración)


## Requisitos

- Java 8 o 7
- IDE de su preferencia
- Usuario en MongoDB
- Base de datos MongoDB en Atlas
- Extensiones para java en caso de usar Visual Studio Code (recomendado) 

## Conexion del proyecto a la base de datos

En el archivo del proyecto ubicado en src/main/resources/application.yml, donde dice "uri" ingresar el enlace de conexion a la base de datos de mongo creada por el estudiante en Atlas. El uri de conexion debe lucir como el siguiente ejemplo: mongodb+srv://admin:mongo@cluster0.ejemplo.mongodb.net/

## Colecciones

Cuando se crea una base de datos en Atlas MongoDB por lo general se pide una coleccion base para comenzar, por ello, a continuacion adjuntamos las colecciones usadas en este proyecto para usar alguna de estas como coleccion base (puede seleccionar cualquiera). La base de datos MongoDB usada para este proyecto, tiene estas colecciones creadas:

- Reservas:
```json
{
  "inicio": "2023-11-16T00:00:00Z",
  "fin": "2023-11-20T00:00:00Z",
  "habitacion": {
    "hotel": "Hotel California",
    "numero": 7,
    "diasocupada": 4,
    "tipo": {
      "nombre": "Suite",
      "precio": 200,
      "dotacion": ["TV", "minibar", "tina"]
    },
    "clientes": [
      {
        "id": 1,
        "nombre": "Juan",
        "entrada": "2023-11-16T00:00:00Z",
        "salida": "2023-11-20T00:00:00Z",
        "consumos": [
          {
            "fecha": "2023-11-17T00:00:00Z",
            "nombre": "masaje",
            "precio": 10
          },
          {
            "fecha": "2023-11-20T00:00:00Z",
            "nombre": "bar",
            "precio": 50
          }
        ]
      } 
      {
        "id": 2,
        "nombre": "Camilo",
        "entrada": "2023-11-16T00:00:00Z",
        "salida": "2023-11-20T00:00:00Z",
        "consumos": [
          {
            "fecha": "2023-11-16T00:00:00Z",
            "nombre": "piscina",
            "precio": 20
            },
          {
            "fecha": "2023-11-20T00:00:00Z",
            "nombre": "bar",
            "precio": 50
          }
        ]
      }
    ]
  }
}

```


## Tecnologias usadas
                     
Este proyecto fue desarrollado haciendo uso de Spring, particularmente Spring Boot para el backend, con entorno de ejecucion node.js y thymeleaf para la conexion de un frontend local con los endpoints definidos. Se recomienda hacer lectura de la documentacion de dichas tecnologias.

## Colaboración
Proyecto desarrollado por Juan Sebastián Sánchez, Andrés Gómez y Juan Felipe Camelo.
