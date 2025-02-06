package test_code;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class UserRegistration extends BaseDriver {
    public String baseUrl = "https://www.unimart.online/";

    @Test(priority = 1)
    public void validRegistrationTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert(); // SoftAssert Object

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"compare\"]/ul/li[3]/a")).click();

        WebElement Name = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[1]/div/input"));
        Name.sendKeys("Jahidul Islam");

        WebElement Number = driver.findElement(By.id("phone-code2"));
        Number.sendKeys("01777324496");

        WebElement Email = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[3]/div/input"));
        Email.sendKeys("jahidullx@gmail.com");

        WebElement Password = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[4]/div/input"));
        Password.sendKeys("Test@123");

        WebElement conf_Pass = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[5]/div/input"));
        conf_Pass.sendKeys("Test@123");

        driver.findElement(By.xpath("//*[@id=\"checkboxExample_1a\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[7]/button")).click();

        Thread.sleep(5000);

        // Validate Registration Success
        boolean isSuccess = driver.getPageSource().contains("Registration successful");
        softAssert.assertTrue(isSuccess, " Registration failed!");

        softAssert.assertAll();
    }

    @Test(priority = 2) //use wrong password

    public void passwordMismatchTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"compare\"]/ul/li[3]/a")).click();

        WebElement Name = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[1]/div/input"));
        Name.sendKeys("Jahidul Islam");

        WebElement Email = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[3]/div/input"));
        Email.sendKeys("jahidullx@gmail.com");

        WebElement Password = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[4]/div/input"));
        Password.sendKeys("Test@1233");

        WebElement conf_Pass = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[5]/div/input"));
        conf_Pass.sendKeys("Wrong Password"); // ভুল password

        driver.findElement(By.xpath("//*[@id=\"checkboxExample_1a\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[7]/button")).click();

        Thread.sleep(5000);

        // Validate Error Message
        boolean isErrorShown = Objects.requireNonNull(driver.getPageSource()).contains("Passwords do not match");
        softAssert.assertTrue(isErrorShown, "Password mismatch error not shown!");

           softAssert.assertAll();
    }

    @Test(priority = 3) // emptyFields Test

    public void emptyFieldsTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert(); // SoftAssert Object

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"compare\"]/ul/li[3]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[7]/button")).click();

        Thread.sleep(5000);

        // Validate Required Field Errors
        softAssert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("Name is required"), "Name validation failed!");
        softAssert.assertTrue(driver.getPageSource().contains("Phone number is required"), "Phone validation failed!");
        softAssert.assertTrue(driver.getPageSource().contains("Email is required"), "Email validation failed!");
        softAssert.assertTrue(driver.getPageSource().contains("Password is required"), "Password validation failed!");

        softAssert.assertAll();
    }
}
