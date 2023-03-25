package steps;

import components.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

import java.io.IOException;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("el usuario abre la aplicación en el navegador")
    public void elUsuarioAbreLaAplicacionEnElNavegador() throws IOException {
        loginPage = launchApplication();
    }

    @Given("el usuario ingresa usuario y contraseña para una cuenta tipo {string}")
    public void elUsuarioIngresaUsuarioYContrasenaParaUnaCuentaTipo(String accountType)  {

        loginPage.typeUsername(getProperties().getProperty("username"));
        loginPage.typePassword(getProperties().getProperty("password"));
    }

    @And("da click en el boton Iniciar Sesión")
    public void daClickEnElBotonIniciarSesion() {
        loginPage.clickLoginButton();
    }

    @Then("el ingreso a la aplicación es exitoso")
    public void elIngresoALaAplicacionEsExitoso() {
        Assert.assertTrue(loginPage.isNavbarDisplayed());
    }


}
