package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UsersTable_StepDefinitions {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    UsersPage usersPage = new UsersPage();

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        System.out.println("expected column names = " + expectedColumnNames);
        System.out.println("expected column names size = " + expectedColumnNames.size());
        wait.until(ExpectedConditions.visibilityOfAllElements(usersPage.showRecordsDropdown));

        List<String> actualColumnNames = new ArrayList<>();
        List<WebElement> columnNamesFromPage=usersPage.tableHeaders;

        for (WebElement each : usersPage.tableHeaders) {
            System.out.println(each.getText());
        }
        columnNamesFromPage.forEach(each->actualColumnNames.add(each.getText()));

        String actualColumnSize = String.valueOf(usersPage.tableHeaders.size());
        System.out.println("actualColumnSize = " + actualColumnSize);

       Assert.assertEquals("Table headers do not contain the expected elements", expectedColumnNames, actualColumnNames);

    }
}


