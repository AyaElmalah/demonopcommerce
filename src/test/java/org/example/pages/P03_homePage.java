package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {
    public WebElement select_Euro()
    {
       return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public List findelements(){
   return  Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));}
public List search_word()
{return Hooks.driver.findElements(By.name("q"));
}
public WebElement search_btn()
{return Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]"));}
    public List hoverCategories()
    {return Hooks.driver.findElements(By.xpath("//ul[@class=\\\"top-menu notmobile\\\"]/li"));}
    public WebElement first_slider(){return Hooks.driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000079_banner_1.jpg\"]"));}
public WebElement second_slider(){return Hooks.driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000080_banner_2.jpg\"]"));}
}
