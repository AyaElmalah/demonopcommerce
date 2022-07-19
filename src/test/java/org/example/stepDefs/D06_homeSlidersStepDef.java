package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {
    P03_homePage slider =new P03_homePage();
    @Given("user go to home page by url")
    public void home_page()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @When("click on first slider")
    public void clickOnFirstSlider() {
        slider.first_slider();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Then("direct user to expected url")
    public void directUserToExpectedUrl() {
        SoftAssert soft =new SoftAssert();
        String eRurl="https://demo.nopcommerce.com/nokia-lumia-1020";
        String aRurl=Hooks.driver.getCurrentUrl();
        soft.assertEquals(aRurl,eRurl);
        soft.assertAll();
    }

    @When("click on second slide")
    public void clickOnSecondSlide() {
slider.second_slider();
Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Then("direct user to expected second slide url")
    public void directUserToExpectedSecondSlideUrl() {
        SoftAssert soft =new SoftAssert();
        String eRurl="https://demo.nopcommerce.com/iphone-6";
        String aRurl=Hooks.driver.getCurrentUrl();
        soft.assertEquals(aRurl,eRurl);
        soft.assertAll();
    }
}
