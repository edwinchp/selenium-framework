Feature: Iniciar sesion en la aplicación

  Background:
  Given el usuario abre la aplicación en el navegador

  Scenario: Logearse usando una cuenta de secretario
    Given el usuario ingresa usuario y contraseña para una cuenta tipo "secretario"
    And da click en el boton Iniciar Sesión
    Then el ingreso a la aplicación es exitoso


