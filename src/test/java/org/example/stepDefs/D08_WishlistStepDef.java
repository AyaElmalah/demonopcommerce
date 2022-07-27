package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;


import java.awt.*;
import java.util.List;

public class D08_WishlistStepDef {
    P03_homePage wishlist =new P03_homePage();
    @When("click on wishlist button")
    public void clickOnWishlistButton() {
        List<WebElement> elements=  wishlist.wishlist_icon();

elements.get(2).click();

    }

    @Then("success message {string}")
    public void successMessage(String message) {
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(wishlist.wishlistMessage().isDisplayed());
        String ecolor="#4bb07a";
        String acolor=wishlist.wishlistMessage().getCssValue("background-color");
        Color.fromString(acolor).asHex();
        soft.assertEquals(Color.fromString(acolor).asHex(),ecolor);
        System.out.println(acolor);
        soft.assertAll();
    }

    @When("click on wishlist message")
    public void clickOnWishlistMessage() throws InterruptedException {
        wishlist.wishlistbtn().click();
        Thread.sleep(4000);
    }

    @Then("check number of wishlist")
    public void checkNumberOfWishlist() {
        String num=wishlist.wishlist_num().getDomAttribute("value");
        System.out.println(num);
        if (Integer.parseInt(num)>0)
        {
            System.out.println("the count of number =" +Integer.parseInt(num));
        }else {
            System.out.println("fail");
        }
    }
}
