## :rocket: Proyecto de Automatizacion de Pruebas para API con Serenity Screenplay

[![Serenity BDD](https://img.shields.io/badge/Serenity%20BDD-3.6.12-green)](http://www.thucydides.info/#/)
[![Cucumber](https://img.shields.io/badge/Cucumber-3.6.12-brightgreen)](https://cucumber.io/)
[![Gradle](https://img.shields.io/badge/Gradle-7.1.1-blue)](https://gradle.org/)

Este proyecto es un ejemplo de implementaci�n de pruebas automatizadas utilizando Serenity Screenplay con Cucumber y Gradle. Las pruebas est�n dise�adas para interactuar con la API "https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBookings".

## Caracteristicas

- Utiliza el enfoque de Screenplay para escribir pruebas m�s legibles y mantenibles.
- Se integra con Cucumber para la definici�n de escenarios de prueba en lenguaje natural.
- Configurado con Gradle como gestor de paquetes y herramienta de construcci�n.

## Requisitos previos

- Java 8 o superior
- Gradle 7.1.1 o superior

## Configuraci�n del proyecto

1. Clona el repositorio:

```shell
git clone https://github.com/Johoxtum/SerenityScreenplayAPI.git
```
## ? Ejecutando las pruebas

```shell
gradle clean test aggregate
```
## Estructura del Proyecto

```Gherkin
src
+ main                                  | Source main
+ test                                  |
 + java                                | Test runners and supporting code
   + features                          | Features set
     + {feature_name}                  | Feature name
       + pages                         | Pages use with webdriver test
       + steps                         | Utility class for definition steps
     + {feature_name}Definition.java   | Definition class 
   + model                             | DTOs, Pojos, VOs, etc ...
   + utils                             | General utility class
   + RunnerTestSuite.java              | Main class
 + resources                           |
   + features                          | Feature files
  ?    + {feature_name}                 | Feature file  specific
          {feature_name}.feature?       |
   + serenity.conf                     | Config file for Serenity
serenity.properties                       | General properties Serenity
```

## Contacto :email:

Si tienes alguna pregunta o comentario sobre este proyecto, no dudes en contactarme:

- Nombre: Johoxtum Jim�nez
- Email: [Johoxtum@gmail.com](mailto:Johoxtum@gmail.com)
- LinkedIn: [Perfil de LinkedIn](https://www.linkedin.com/in/johoxtum-jimenez-463ba1211/)
-
�Gracias por tu inter�s en este proyecto de automatizaci�n QA con Serenity Screenplay!
