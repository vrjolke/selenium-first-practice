package com.codecool.bence.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SeleniumTasks {

    public static String driverPath = "/usr/bin/chromedriver";
    public static WebDriver driver;


    public SeleniumTasks() {
        this.driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    public String navigateToSimpleForms() {
        driver.navigate().to("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("treemenu")));
        driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.linkText("Simple Form Demo")).click();
        String url = driver.getCurrentUrl();

        return url;
    }


    public String singleFiendAndButton(String inputMessage) {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        driver.findElement(By.id("user-message")).sendKeys(inputMessage);
        driver.findElement(By.cssSelector("#get-input > button")).click();
        String message = driver.findElement(By.id("display")).getText();

        return message;
    }

    public String twoFieldsAndButton(String input1, String input2) {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sum1")));

        driver.findElement(By.id("sum1")).sendKeys(input1);
        driver.findElement(By.id("sum2")).sendKeys(input2);
        driver.findElement(By.cssSelector("#gettotal > button")).click();
        String sum = driver.findElement(By.id("displayvalue")).getText();

        return sum;

    }

    public String singleCheckbox() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        driver.findElement(By.id("isAgeSelected")).click();
        String message = driver.findElement(By.id("txtAge")).getText();

        return message;
    }

    public void navigateAndClickCheckboxDemoButton() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.id("check1")).click();
    }

    public boolean multipleCheckboxCheckAll() {
        navigateAndClickCheckboxDemoButton();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input.cb1-element"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }


    public boolean multipleCheckboxUncheckAll() {
        navigateAndClickCheckboxDemoButton();
        driver.findElement(By.id("check1")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input.cb1-element"));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

    public String multipleCheckboxUncheckOne() {
        navigateAndClickCheckboxDemoButton();
        driver.findElements(By.cssSelector("input.cb1-element")).get(0).click();
        String buttonText = driver.findElement(By.id("check1")).getAttribute("value");

        return buttonText;

    }

    public String selectList() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        Select dropdownDays = new Select(driver.findElement(By.id("select-demo")));
        dropdownDays.selectByVisibleText("Tuesday");
//        String selectedOption = dropdownDays.getFirstSelectedOption().getText();
        String selectedOption = driver.findElement(By.cssSelector("div.panel-body > p.selected-value")).getText();
        return selectedOption;

    }

    public String selectListAlternative() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        driver.findElement(By.id("select-demo")).click();
        driver.findElement(By.cssSelector("#select-demo > option:nth-child(4)")).click();
        String selectedOption = driver.findElement(By.cssSelector("div.panel-body > p.selected-value")).getText();
        return selectedOption;
    }

    public String[] groupRadioButtons(){
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        String[] results = new String[2];

        driver.findElement(By.cssSelector(generateRadioButtonSelector(2,2))).click();
        driver.findElement(By.cssSelector(generateRadioButtonSelector(3,2))).click();
        driver.findElement(By.cssSelector("#easycont div.panel-body > button")).click();
        String resultText = driver.findElement(By.cssSelector("#easycont div.panel-body > p.groupradiobutton")).getText();
        results[0] = resultText;

        driver.findElement(By.cssSelector(generateRadioButtonSelector(2,3))).click();
        driver.findElement(By.cssSelector(generateRadioButtonSelector(3,4))).click();
        driver.findElement(By.cssSelector("#easycont div.panel-body > button")).click();
        resultText = driver.findElement(By.cssSelector("#easycont div.panel-body > p.groupradiobutton")).getText();
        results[1] = resultText;


        return results;
    }

    public String generateRadioButtonSelector(int row, int col){
        return "#easycont div.panel-body > div:nth-child("+row+") > label:nth-child("+col+") > input[type=radio]";
    }

}


