package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {
public WebElement registerlink()
{
    return Hooks.driver.findElement(By.className("ico-register"));

}
public WebElement gender()
{ return Hooks.driver.findElement(By.className("female"));}
    public WebElement first_name()
    {return  Hooks.driver.findElement(By.name("FirstName"));}
    public WebElement last_name()
    {return  Hooks.driver.findElement(By.name("LastName"));}
    public WebElement birth_day()
    { return Hooks.driver.findElement(By.name("DateOfBirthDay"));}
    public WebElement birth_month()
    { return Hooks.driver.findElement(By.name("DateOfBirthMonth"));}
    public WebElement birth_year()
    { return Hooks.driver.findElement(By.name("DateOfBirthYear"));}
    public WebElement email()
    {return Hooks.driver.findElement(By.id("Email"));}
    public WebElement password()
    {return Hooks.driver.findElement(By.id("Password"));}
    public WebElement confirm_password()
    {return Hooks.driver.findElement(By.id("ConfirmPassword"));}
    public WebElement reg_button()
    {
        return Hooks.driver.findElement(By.cssSelector("button[name=\"register-button\"]"));
    }
    public WebElement success_message()
    { return Hooks.driver.findElement(By.className("result"));}

}
