package org.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/******************************************************************
 * PAGE OBJECT ENCAPSULATES THE HOME PAGE by Jorge Tantas
 ********************************************************************/

public class Home {

    /**
     * Locates the elements matching given CSS selectors
     * all elements are assigned to the following variables
     */

    By homeHeader = By.cssSelector("h1[class='None']");
    By editLink = By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) a:nth-child(1)");
    By homeLastName = By.cssSelector("tbody tr:nth-child(2) td:nth-child(3)");
    By homeBirthDate = By.cssSelector("tbody tr:nth-child(2) td:nth-child(4)");
    By homeState = By.cssSelector("tbody tr:nth-child(2) td:nth-child(7)");


    /**
     * Verify the header <h1> when you open the home page
     * Verify if the header = "Popup Editing"
     */

    public void verifyHeader() {
        $(homeHeader).shouldHave(Condition.text("Popup Editing"));
    }

    /**
     * clickEditLink method to click on Edit Link
     * The element should be visible
     * A new window frem is open after this event
     */
    public void clickEditLink() {
        $(editLink).shouldBe(Condition.visible).click();
    }

    /**
     * Verify Table Changes after editing a Employee
     * Verify the new lastname value from the table
     * Verify the new birtdate value from the table

     */
    public void verifyTableChanges() {

        $(homeLastName).shouldHave(Condition.text("Testing123"));
        $(homeBirthDate).shouldHave(Condition.text("1/24/1980"));
    }

}
