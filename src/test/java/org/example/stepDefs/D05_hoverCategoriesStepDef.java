package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
P03_homePage hover=new P03_homePage();
    @When("hover on one of main categories")
    public void hoverOnOneOfMainCategories() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        List<WebElement> mainLinks = hover.hoverCategories();
        action.moveToElement((WebElement) mainLinks).perform();
        int count= mainLinks.size();
        System.out.println("count is "+count);
        int min = 0;
        int max = count-1;
        int selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
        action.moveToElement(mainLinks.get(selectedCategory)).perform();
        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
        System.out.println("to know which category is selected:   " +selectedCategoryText);
        Thread.sleep(2000);
        selectedCategory = selectedCategory+1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)["+selectedCategory+"]/li";
        List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));

        // minimize implicit wait to not waste time if it's empty
        Hooks.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        Hooks.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        String selectedSubCategoryText;
        if(!subCategoryLinks.isEmpty()) {
            int subCategoryCount = subCategoryLinks.size();
            System.out.println("profile links " + subCategoryCount);
            System.out.println(subCategoryLinks.get(0).getText());
            System.out.println(subCategoryLinks.get(1).getText());
            System.out.println(subCategoryLinks.get(2).getText());
            int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
            subCategoryLinks.get(selectedSubCategory).click();
            // Do your assertion on selected sub category
        }
        else
        {
            mainLinks.get(selectedCategory).click();
            // Do your assertion on selected main category
        }

        // reset it to the initial value
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @And("click on sub category")
    public void clickOnSubCategory() {
    }


}
