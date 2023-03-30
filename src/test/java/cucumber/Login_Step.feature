Feature: Iniciar sesion en la aplicación

  Background:
  Given el usuario abre la aplicación en el navegador


  Scenario: Esta prueba debe pasar
    Given el usuario ingresa usuario y contraseña válida para una cuenta tipo "secretario"
    And da click en el boton Iniciar Sesión
    Then el ingreso a la aplicación es exitoso


  Scenario: A esta prueba le falta un step
    Given el usuario ingresa usuario y contraseña válida para una cuenta tipo "secretario"
    And da click en el boton Iniciar Sesión
    Then el ingreso



  Scenario: Esta otra prueba debe fallar jeje
    Given el usuario ingresa usuario y contraseña inválida para una cuenta tipo "secretario"
    #And da click en el boton Iniciar Sesión
    Then el mensaje es mostrado "Falló al entrar"

  Scenario: Esta prueba debe pasar
    Given el usuario ingresa usuario y contraseña válida para una cuenta tipo "secretario"
    And da click en el boton Iniciar Sesión
    Then el ingreso a la aplicación es exitoso