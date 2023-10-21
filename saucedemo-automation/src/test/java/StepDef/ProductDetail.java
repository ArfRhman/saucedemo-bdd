package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetail {
    WebDriver driver;
    @Given("User should be login in saucedemo for show product detail")
    public void userShouldBeLoginInSaucedemoForShowProductDetail() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @When("user click Name Product in list first product")
    public void userClickNameProductInListFirstProduct() throws InterruptedException {
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
        Thread.sleep(500);
    }

    @Then("show to page product detail which user choosen")
    public void showToPageProductDetailWhichUserChoosen() {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario : Show Product Detail");
        System.out.println("If Success Choose Product Detail " + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + ", You Can See Title Product Name " + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + " in Product Detail Page");
        driver.quit();
    }
}
