package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ConverterStepdefs {
    @Given("I go to {string} page")
    public void iGoToPage(String arg0) {
        getDriver().get("https://www.unitconverters.net/");
    }

    @When("I click on {string}")
    public void iClickOn(String tabname) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'"+tabname+"')]")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String from, String to) {
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[contains(text(),'"+ from +"')]")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'"+ to +"')]")).click();
    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String input, String output) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(input);
        assertThat(getDriver().findElement(By.xpath("//input[@name='toVal']")).getText().contains(output));
    }
}
