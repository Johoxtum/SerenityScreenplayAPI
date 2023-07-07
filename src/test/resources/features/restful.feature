# encoding :iso-8859-1
@Restful
Feature: Autenticaci�n en la API y consumo de API
  Como usuario
  Quiero autenticarme en la API
  Para acceder a los recursos protegidos

  @Rest
  Scenario: Autenticaci�n exitosa
    Given el usuario se quiere autenticar
    When se env�a una solicitud POST con los siguientes datos:
      | username | password    |
      | admin    | password123 |
    Then la respuesta debe tener un c�digo de estado 200
    And la respuesta debe contener el "token_acceso" con un 200

   @Rest_Get
  Scenario: Obtener informaci�n de los libros existentes
    Given que el usuario desea conocer los libros disponibles
    When env�a una solicitud a la base de datos
    Then la respuesta debe tener un c�digo de estado 200
    And la respuesta debe contener el "libros_disponibles" con un 200