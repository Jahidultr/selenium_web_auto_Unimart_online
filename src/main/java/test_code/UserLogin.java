package test_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserLogin extends BaseDriver{
    public String baseUrl = "https://www.unimart.online/";

    @Test(priority = 1)
    public void loginUserTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"compare\"]/ul/li[2]/a")).click();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div/div/div/div/div[2]/div/form/div[1]/div/input"));
        username.sendKeys("jahidul@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("sadjhf@233");

        WebElement checkmark = driver.findElement(By.xpath("//*[@id=\"demo-form-checkbox\"]"));
        checkmark.click();

        WebElement login = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div/div/div/div/div[2]/div/form/div[4]/button"));
        login.click();

        Thread.sleep(5000);

//        Login validation
        try {
            WebElement dashboardTitle = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
            softAssert.assertTrue(dashboardTitle.isDisplayed(), "Login Failed! Dashboard page not loaded!");
            System.out.println("✅ Login Successful! Dashboard Page Loaded.");
        } catch (Exception e) {
            System.out.println("Login Failed! Dashboard not found.");
            softAssert.fail(" Dashboard page not displayed!");
        }
        softAssert.assertAll();


    }

    @Test(priority = 2)
    public void invalidUserTest() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"compare\"]/ul/li[2]/a")).click();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div/div/div/div/div[2]/div/form/div[1]/div/input"));
        username.sendKeys("jahidul@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("sadjhf@2343");

        WebElement checkmark = driver.findElement(By.xpath("//*[@id=\"demo-form-checkbox\"]"));
        checkmark.click();

        WebElement login = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div/div/div/div/div[2]/div/form/div[4]/button"));
        login.click();

//        Login Invalid
        try {
            WebElement dashboardTitle = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
            softAssert.assertTrue(dashboardTitle.isDisplayed(), "Login Failed! Dashboard page not loaded!");
            System.out.println("Unexpected: Dashboard Page Loaded, but login was invalid.");
        } catch (Exception e) {
            System.out.println("Login Failed! Dashboard not found.");
            softAssert.fail("Dashboard page not displayed!");
        }

        softAssert.assertAll();

        Thread.sleep(5000);


    }


}
