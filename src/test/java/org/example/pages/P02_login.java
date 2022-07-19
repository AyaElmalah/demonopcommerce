package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {
    public WebElement login()
    {return  Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));}
    public WebElement email()
    {
        return Hooks.driver.findElement(By.className("email"));
    }

    public WebElement password()
    {
       // return Hooks.driver.findElement(By.cssSelector("div[type=\"password\"]"));
        return Hooks.driver.findElement(By.cssSelector("input[type=\"password\"]"));
    }

    public WebElement loginbtn() {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }
    public WebElement myaccount()
    {return Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"]"));}
    public WebElement errorMessage(){return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));}
//    public void loginSteps(String email ,String password){
//        //driver.navigate().to("https://the-internet.herokuapp.com/login");
//
//   email().sendKeys(email);
//        password().sendKeys(password);}
}

