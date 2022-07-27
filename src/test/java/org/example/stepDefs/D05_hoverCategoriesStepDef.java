package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    String subCategoryName;
P03_homePage hover=new P03_homePage();
//    @When("hover on one of main categories then click on sub category")
//    public void hoverOnOneOfMainCategories() throws InterruptedException {
//        Actions actions=new Actions(Hooks.driver);
//        List<WebElement> mainLinks = hover.hoverCategories();
//        int count = mainLinks.size();
//        System.out.println("count is "+count);
//        int min = 0;
//        int max = count-1;
//        int selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
//        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
//        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
//        System.out.println("to know which category is selected:   " +selectedCategoryText);
//        Thread.sleep(2000);
//
//       // selectedCategory = selectedCategory+1;
//        String locator = "(//ul[@class='top-menu notmobile']//ul)["+selectedCategory+"]/li";
//        List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
//
//        // minimize implicit wait to not waste time if it's empty
//       Hooks.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//
//        String selectedSubCategoryText;
//        if(!subCategoryLinks.isEmpty()) {
//            int subCategoryCount = subCategoryLinks.size();
//            System.out.println("profile links " + subCategoryCount);
//            System.out.println(subCategoryLinks.get(0).getText());
//            System.out.println(subCategoryLinks.get(1).getText());
//            System.out.println(subCategoryLinks.get(2).getText());
//            int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
//            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
//            subCategoryLinks.get(selectedSubCategory).click();
//            // Do your assertion on selected sub category
//            String er=Hooks.driver.getTitle();
//            System.out.println("expected title "+er);
//        }
//        else
//        {
//            mainLinks.get(selectedCategory).click();
//            String er=Hooks.driver.getTitle();
//            System.out.println("expected title "+er);
//        }
//
//Thread.sleep(2000);
//        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//
//
//    }
@Given("User hover on random main category on the top menu")
public void user_hover_on_random_main_category_on_the_top_menu() {
    hover.categoriesMenu();
}

    @When("user click on a sub category of product")
    public void user_click_on_a_sub_category_of_product() {
        subCategoryName = hover.getSubCategory();

    }




    @Then("verify if the category title is matching")
    public void verify_if_the_category_title_is_matching()  {
        String expectedTitle = subCategoryName;
        String actualTitle = hover.getPageTitle().getText();
        System.out.println("expectedTitle " +expectedTitle);
        System.out.println("actualTitle "+actualTitle);
        Assert.assertTrue(actualTitle.toLowerCase().trim().contains(expectedTitle.toLowerCase().trim()));
    }


}
