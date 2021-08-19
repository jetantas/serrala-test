package org.selenide.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.selenide.pages.Employee;
import org.selenide.pages.Home;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/************************************************************************************************
 * TEST EDIT EMPLOYEE FEATURE by Jorge Tantas
 ************************************************************************************************/
public class EmployeeTest {

    /**
     * Configure the page before execute test
     * Open the home page
     */

    @BeforeClass
    public static void openSite() {
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://js.devexpress.com/Demos/WidgetsGallery/Demo/DataGrid/PopupEditing/Angular/Light/";
        Configuration.startMaximized = true;
        open("/");
    }

    /**
     * testEditEmployee is the main test scenario
     * Create objects to be used during the test
     * methods from Home and Employee class are called
     */

    @Test
    public void testEditEmployee() {
        Home home = new Home();
        Employee employee = new Employee();
        home.verifyHeader();
        switchTo().frame("demoFrame");
        home.clickEditLink();
        employee.editEmployee("Testing123", "1/24/1980","Colorado");
        home.verifyTableChanges();
    }

    /**
     * Close the Windows
     */
    @AfterClass
    public static void closeSite() {
        closeWindow();
    }
}
