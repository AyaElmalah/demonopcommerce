package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage follow =new P03_homePage();
    @When("user opens facebook link")
    public void userOpensFacebookLink() throws InterruptedException {
        follow.facebook().click();
        Thread.sleep(4000);
    }
    @When("user opens twitter link")
    public void userOpensTwitterLink() throws InterruptedException {
        follow.twitter().click();
        Thread.sleep(4000);
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String url) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
     Hooks.driver.switchTo().window(tabs.get(1));
     Thread.sleep(2000);
        System.out.println("current url "+Hooks.driver.getCurrentUrl());
        System.out.println("current title "+Hooks.driver.getTitle());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(),url);

       Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
    }

    @When("user opens rss link")
    public void userOpensRssLink() throws InterruptedException {
        follow.new_rss().click();
        Thread.sleep(4000);
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() throws InterruptedException {
follow.youtube().click();
        Thread.sleep(4000);
    }



}
