package test_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExample extends BaseDriver{

    String unimart  = "https://www.saucedemo.com/";

    @Test(priority = 0)
    public void assertionTest() throws InterruptedException {

        driver.get(unimart);
        driver.manage().window().maximize();


        String exceptedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,exceptedTitle);
        Thread.sleep(10000);
    }
    @Test(priority = 1)
    public void LoginTest(){

        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        login.click();

    }
}
