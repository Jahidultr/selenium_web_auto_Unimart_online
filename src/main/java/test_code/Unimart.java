package test_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Unimart extends BaseDriver{

    public String baseUrl = "https://www.unimart.online/";

    @Test(priority = 1)
    public  void loginTest() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"compare\"]/ul/li[3]/a")).click();

        //Registration
        WebElement name =  driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[1]/div/input"));
        name.sendKeys("Jahidul Islam");

        WebElement number = driver.findElement(By.id("phone-code2"));
        number.sendKeys("01773249668");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[3]/div/input"));
        email.sendKeys("jahidul@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[4]/div/input"));
        password.sendKeys("sadjhf@233");

        WebElement confirm_pass = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[5]/div/input"));
        confirm_pass.sendKeys("sadjhf@233");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"checkboxExample_1a\"]"));
        checkbox.click();

        WebElement create_acc = driver.findElement(By.xpath("//*[@id=\"reg-form\"]/div[7]/button"));
        create_acc.click();


        Thread.sleep(5000);
    }
}
