package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import javax.lang.model.element.Element;
import java.util.List;

public class D04_searchStepDef {
    P03_homePage homePage=new P03_homePage();
    @Given("user navigates to home page")
    public void home_page()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("I enter product name as {string}")
    public void iEnterProductNameAs(String product) throws InterruptedException {
        System.out.println(product);
        List<WebElement> elements=  homePage.search_word();

        for(int i=0;i<elements.size();i++)
        {

            elements.get(i).sendKeys(product);
            System.out.println(" Count number of search results =" +elements.size());

        }
        elements.get(1);

    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() throws InterruptedException {
        SoftAssert soft =new SoftAssert();
        homePage.search_btn().click();
        Thread.sleep(4000);
        String eR="https://demo.nopcommerce.com/search?q=";
        String aR= Hooks.driver.getCurrentUrl();
     soft.assertEquals(aR.contains(eR),true);
     

    }

    @When("I enter product name using sku as {string}")
    public void iEnterProductNameUsingSkuAs(String product) {
        System.out.println(product);
        List<WebElement> elements=  homePage.search_word();

        for(int i=0;i<elements.size();i++)
        {

            elements.get(i).sendKeys(product);
            System.out.println(" Count number of search results =" +elements.size());
        }
        elements.get(0);


    }
}
