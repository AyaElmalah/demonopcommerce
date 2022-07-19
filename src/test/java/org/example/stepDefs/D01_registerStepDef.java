package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register register=new P01_register();
    @Given("user go to register page")
    public void goRegisterPage()
    {
register.registerlink().click();
    }
    @When("user select gender type")
    public void select_gender(){
register.gender().click();
    }
    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enter_name()
    {
        register.first_name().sendKeys("automation");
        register.last_name().sendKeys("tester");
    }
  @And("user enter date of birth")
    public void enter_date()
  {
      Select sel1=new Select(register.birth_day());
      sel1.selectByValue("1");
      Select sel2=new Select(register.birth_month());
      sel2.selectByVisibleText("November");
      Select sel3=new Select(register.birth_year());
      sel3.selectByValue("1995");

  }
    @And("user enter email \"test@example.com\" field")
    public void enter_email() {
        register.email().sendKeys("test105@example.com");
    }
    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
                public void fills_password()
        {
            register.password().sendKeys("P@ssw0rd");
            register.confirm_password().sendKeys("P@ssw0rd");
        }
    @And("user clicks on register button")
    public void click_button()
    {
        register.reg_button().click();
    }
    @Then("success message is displayed")
    public void success_message()
    {
        SoftAssert soft =new SoftAssert();
        String eR="Your registration completed";
        String aR= register.success_message().getText();
        soft.assertTrue(aR.contains(eR),"first assertion true");
       String excolor="rgba(76, 177, 124, 1)";
        String aRcolor= register.success_message().getCssValue("color");
        soft.assertTrue(aRcolor.contains(excolor));
        System.out.println(aRcolor.contains(excolor));
        soft.assertAll();
    }
}
