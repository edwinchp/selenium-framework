Feature: Iniciar sesion en la aplicación

  Background:
  Given el usuario abre la aplicación en el navegador


  Scenario: Esta prueba debe fallar
    Given el usuario ingresa usuario y contraseña inválida para una cuenta tipo "secretario"
    And da click en el boton Iniciar Sesión
    Then el mensaje es mostrado "Falló al entraa"


