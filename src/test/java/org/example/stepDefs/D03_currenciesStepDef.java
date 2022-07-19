package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.ListIterator;

public class D03_currenciesStepDef {
    P03_homePage homePage=new P03_homePage();
    @Given("user go to home page")
    public void home_page()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @When("Select Euro currency from the dropdown list")
    public void select_Euro()
    { Select select_Euro=new Select(homePage.select_Euro());
        select_Euro.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }
    @Then("Euro Symbol \\(€) is shown on the four products")
    public void euro_symbol() {

        SoftAssert soft =new SoftAssert();
        List<WebElement> elements=  homePage.findelements();
        WebElement q;
        for(int i=0;i<elements.size();i++)
        {
            q=elements.get(i);
            System.out.println(q.getText());
            soft.assertTrue((q.getText()).contains("€"),"Euro Symbol (€) is shown on the four products");
soft.assertAll();
        }
    }


}
