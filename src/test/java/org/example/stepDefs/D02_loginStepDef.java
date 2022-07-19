package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;


import java.awt.*;

public class D02_loginStepDef {
    P02_login login=new P02_login();
    @Given("user go to login page")
    public void login_page()
    {
login.login().click();
    }

//    @When("user login with {string}")
//    public void valid_data(String email,String password)
//    {
//        login.loginSteps(email,password);
//    }

    @When("user login with valid {string}")
    public void userLoginWithValid(String email) {
        login.email().sendKeys(email);
    }

    @And("valid {string}")
    public void valid(String password) {
        login.password().sendKeys(password);
    }
    @And("user press on login button")
    public void login_button() throws InterruptedException {
        login.loginbtn().click();
        Thread.sleep(4000);
    }

    @When("user login with invalid {string}")
    public void userLoginWithInvalid(String email) {
login.email().sendKeys(email);
    }

    @And("invalid {string}")
    public void invalid(String password) {
        login.password().sendKeys(password);
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft =new SoftAssert();
String eR="https://demo.nopcommerce.com/";
String aR=Hooks.driver.getCurrentUrl();
        System.out.println(aR);
soft.assertEquals(aR,eR);
soft.assertTrue(login.myaccount().isDisplayed(),"“My account” tab isDisplayed");
   soft.assertAll();

    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();
        String eR = "Login was unsuccessful.";
        String aR = login.errorMessage().getText();
        soft.assertTrue(aR.contains(eR), "true");
        String eRcolor = "#e4434b";
        String aRcolor = login.errorMessage().getCssValue("color");
        System.out.println(aRcolor);
        Color.fromString(aRcolor).asHex();
        soft.assertEquals(Color.fromString(aRcolor).asHex(), eRcolor);
        soft.assertAll();

    }
}
