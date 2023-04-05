package steps;

import components.BaseTest;
import components.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

import java.io.IOException;

public class LoginSteps extends BaseTest {

    DriverFactory driverFactory;
    WebDriver driver;
    private LoginPage loginPage;


    @Given("el usuario abre la aplicación en el navegador")
    public void elUsuarioAbreLaAplicacionEnElNavegador() throws IOException {

        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo(getProperties().getProperty("url"));
    }

    @Given("el usuario ingresa usuario y contraseña válida para una cuenta tipo {string}")
    public void elUsuarioIngresaUsuarioYContrasenaValidaParaUnaCuentaTipo(String accountType) {
        loginPage.typeUsername(getProperties().getProperty("username"));
        loginPage.typePassword(getProperties().getProperty("password"));
    }

    @Given("el usuario ingresa usuario y contraseña inválida para una cuenta tipo {string}")
    public void elUsuarioIngresaUsuarioYContrasenaInvalidaParaUnaCuentaTipo(String accountType) {
        loginPage.typeUsername("Secretario Cualquiera");
        loginPage.typePassword("password");
    }

    @And("da click en el boton Iniciar Sesión")
    public void daClickEnElBotonIniciarSesion() {
        loginPage.clickLoginButton();
    }

    @Then("el ingreso a la aplicación es exitoso")
    public void elIngresoALaAplicacionEsExitoso() {
        Assert.assertTrue(loginPage.isNavbarDisplayed());
    }

    @Then("el mensaje es mostrado {string}")
    public void elMensajeEsMostrado(String message) {
        Assert.assertEquals(loginPage.getErrorMessage(), message);
    }

    @After
    public void afterScenario(){
        driverFactory.closeDriver();
    }
}
