package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Gayani Abewickrama
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/gayaniabewickrama/Downloads/chromedriver-mac-x64/chromedriver");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(5);

        // Load a webpage in chromium browser.
        driver.get(url);

        /*
         * How to identify a HTML input field - Step 1: Inspect the webpage, Step 2:
         * locate the input field, Step 3: Find out how to identify it, by id/name/...
         */

        // Find first input field which is firstname
        WebElement firstNameElement = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + firstNameElement);
        // Send first name
        firstNameElement.sendKeys("Gayani");

        // Find following input fields and populate with values
        WebElement lastNameElement = driver.findElement(By.id("lastname"));
        lastNameElement.sendKeys("Abewickrama");
        
        // Inserting the phone number field
        WebElement phoneNumberElement = driver.findElement(By.id("phoneNumber"));
        phoneNumberElement.sendKeys("0414545368");

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("gayaniabewickrama99@gmail.com");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("Abcd@1234");
        
        // Inserting the confirm password field
        WebElement confirmPasswordElement = driver.findElement(By.id("confirmPassword"));
        confirmPasswordElement.sendKeys("Abcd@1234");

        // Identify button 'Create account' and click to submit using Selenium API.
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createAccountButton.click();

        // Take screenshot using Selenium API and save the image file
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
            System.out.println("Screenshot captured and saved as screenshot.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sleep a while
        sleep(5);

        // close chrome driver
        driver.close();
    }
    
    public static void alternative_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/gayaniabewickrama/Downloads/chromedriver-mac-x64/chromedriver");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load the alternative registration page.
        driver.get(url);

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("gayaniabewickrama99@gmail.com");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("Abcd@1234");
        
        WebElement firstNameElement = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + firstNameElement);
        // Send first name
        firstNameElement.sendKeys("Gayani");

        // Find following input fields and populate with values
        WebElement lastNameElement = driver.findElement(By.id("lastname"));
        lastNameElement.sendKeys("Abewickrama");

        // Identify button 'Create account' and click to submit using Selenium API.
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createAccountButton.click();

        // Take a screenshot and save it as an image file.
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("alternative_registration.png"));
            System.out.println("Screenshot captured and saved as alternative_registration.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sleep briefly to allow time for the screenshot to be captured.
        sleep(2);

        // Close the browser.
        driver.quit();
    }


    public static void main(String[] args) {
        officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        alternative_registration_page("https://www.bunnings.com.au/register");
    }
}
