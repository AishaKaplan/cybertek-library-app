package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageNavigations_StepDefinitions {
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 20);
    UsersPage usersPage=new UsersPage();
    LandingPage landingPage=new LandingPage();
    Select select;

    @When("I click on {string} link")
    public void i_click_on_link(String link) {

        switch (link.toLowerCase()) {
            case "dashboard":
                landingPage.dashboardPageLink.click();
                break;
            case "users":
                landingPage.usersPageLink.click();
                break;
            case "books":
                landingPage.booksPageLink.click();
                break;
        }
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {

        select=new Select(usersPage.showRecordsDropdown);
        String actual=select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected+"", actual); //made int to String value
    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options.size() = "+ options.size());
        System.out.println("options = "+ options);

        select=new Select(usersPage.showRecordsDropdown);
        List<WebElement> webElements=select.getOptions();
        List<String> elemTexts=new ArrayList<>();
        for(WebElement each : webElements){
            elemTexts.add(each.getText());
        }
        Assert.assertEquals(options, elemTexts);
    }



}
