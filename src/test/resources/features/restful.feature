# encoding :iso-8859-1
@Restful
Feature: Autenticación en la API y consumo de API
  Como usuario
  Quiero autenticarme en la API
  Para acceder a los recursos protegidos

  @Rest
  Scenario: Autenticación exitosa
    Given el usuario se quiere autenticar
    When se envía una solicitud POST con los siguientes datos:
      | username | password    |
      | admin    | password123 |
    Then la respuesta debe tener un código de estado 200
    And la respuesta debe contener el "token_acceso" con un 200

   @Rest_Get
  Scenario: Obtener información de los libros existentes
    Given que el usuario desea conocer los libros disponibles
    When envía una solicitud a la base de datos
    Then la respuesta debe tener un código de estado 200
    And la respuesta debe contener el "libros_disponibles" con un 200