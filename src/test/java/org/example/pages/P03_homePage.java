package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class P03_homePage {
    int mainItemIndex;
    boolean isHasChild;
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
{return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));}
    public List hoverCategories()
    {return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));}
    public WebElement first_slider(){return Hooks.driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000079_banner_1.jpg\"]"));}
public WebElement second_slider()
{return Hooks.driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000080_banner_2.jpg\"]"));}

public WebElement facebook(){
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));}

public WebElement twitter(){
        return Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
}
    public WebElement new_rss(){
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }
    public WebElement youtube(){
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }
    public List wishlist_icon()
    {return Hooks.driver.findElements(By.cssSelector("button[title=\"Add to wishlist\"]"));}
    public WebElement wishlistMessage()
    {return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));}
    public WebElement wishlistbtn(){
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/wishlist\"]"));
    }
    public WebElement wishlist_num(){
        return Hooks.driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
    }
    public WebElement confirmNameProduct(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"sku\"]//span[@class=\"value\"]"));
    }
    public WebElement titleName()
    {return Hooks.driver.findElement(By.cssSelector("div[class=\"picture\"]"));}


   public boolean hasChildren(WebElement node) {
        return node.findElements(By.xpath("./descendant-or-self::*")).size() > 2;
    }
    public void categoriesMenu() {
        Actions action = new Actions(Hooks.driver);
        //Thread.sleep(1000);
        List<WebElement> lis = Hooks.driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));

        mainItemIndex = (int) (Math.random() * lis.size());

        WebElement mainLi = lis.get(mainItemIndex);
        action.moveToElement(mainLi).perform();
        isHasChild = hasChildren(mainLi);
    }

    public String getSubCategory() {

        String subTitle;
        if (isHasChild) {
            isHasChild = false;
            List<WebElement> as = Hooks.driver.findElements(By.xpath(String.format("//ul[@class='top-menu notmobile']/li[position()=%d]//ul//li", mainItemIndex + 1)));
            //System.out.println(as.get((int) (Math.random() * as.size())).getText());

            int subCategoryIndex = (int) (Math.random() * as.size());
            subTitle = as.get(subCategoryIndex).getText();
            as.get(subCategoryIndex).click();
        } else {
            WebElement catNoChild = Hooks.driver.findElement(By.xpath(String.format("//ul[@class='top-menu notmobile']/li[position()=%d]//a", mainItemIndex + 1)));
            subTitle = catNoChild.getText();
            catNoChild.click();
        }

        return subTitle;
    }
    public WebElement getPageTitle() {
        //Thread.sleep(2000);
        return Hooks.driver.findElement(By.xpath("//div[@class='page-title']//h1"));
    }
}
