package org.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

/******************************************************************
 * PAGE OBJECT ENCAPSULATES THE EMPLOYEE PAGE by Jorge Tantas
 ********************************************************************/

public class Employee {

    /**
     * Locates the elements matching given xPATHs
     * all elements are assigned to the following variables
     */

    By lastName = By.xpath("//body//div[@data-bind='dxControlsDescendantBindings: true']//div[@role='form']//div//div//div//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]");
    By birthDate = By.xpath("//div[@class='dx-popup-content']//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]");
    By myState = By.xpath("//input[@aria-haspopup='listbox']");
    By btnSave = By.xpath("//div[@aria-label='Save']//div[@class='dx-button-content']");

    /**
     * Assign new value(strLastName) the locator lastName
     */
    public void setLastName(String strLastName) {
        $(lastName).clear();
        $(lastName).setValue(strLastName).pressEnter();
    }

    /**
     * Assign new value(strBirthDate) the locator birthDate
     */
    public void setBirthDate(String strBirthDate) {
        $(birthDate).clear();
        $(birthDate).sendKeys(strBirthDate);
    }

    /**
     * Assign new value(strMyState) the locator myState
     */
    public void setMyState(String strMyState) {

        $(myState).sendKeys(Keys.COMMAND, Keys.chord("a"));
        $(myState).sendKeys(Keys.BACK_SPACE);
        $(myState).sendKeys(strMyState);
    }

    /**
     * call the event click on Save button
     */
    public void clickSave() {
        $(btnSave).shouldBe(Condition.visible).click();
    }

    /**
     * This method edit the employee given: lastname, birthdate and state
     * Save the changes and it is updated into the table
     */
    public void editEmployee(String strLastName, String strBirthDate, String strMyState) {
        this.setLastName(strLastName);
        this.setBirthDate(strBirthDate);
        this.setMyState(strMyState);
        this.clickSave();
    }
}
