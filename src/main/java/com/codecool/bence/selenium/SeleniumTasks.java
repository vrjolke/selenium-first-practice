package com.codecool.bence.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTasks {

    public static String driverPath = "/usr/bin/chromedriver";
    public static WebDriver driver;


    public SeleniumTasks() {
        this.driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    public void navigateToSimpleForms(){
        driver.navigate().to("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("treemenu")));
        driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.linkText("Simple Form Demo")).click();
    }


    public String singleFiendAndButton(String inputMessage){
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        driver.findElement(By.id("user-message")).sendKeys(inputMessage);
        driver.findElement(By.cssSelector("#get-input > button")).click();
        String message = driver.findElement(By.id("display")).getText();

        return message;
    }

    public String twoFieldsAndButton(String input1, String input2){
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sum1")));

        driver.findElement(By.id("sum1")).sendKeys(input1);
        driver.findElement(By.id("sum2")).sendKeys(input2);
        driver.findElement(By.cssSelector("#gettotal > button")).click();
        String sum = driver.findElement(By.id("displayvalue")).getText();

        return sum;

    }

}
