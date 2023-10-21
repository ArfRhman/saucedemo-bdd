package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
    WebDriver drivers;
    @Given("User should be login in saucedemo for add to cart")
    public void userShouldBeLoginInSaucedemoForAddToCart() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        drivers = new ChromeDriver();
        drivers.get("https://www.saucedemo.com");
        Thread.sleep(1000);
        drivers.findElement(By.name("user-name")).sendKeys("standard_user");
        drivers.findElement(By.name("password")).sendKeys("secret_sauce");
        drivers.findElement(By.name("password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    @When("user click button Add to Cart in first list product")
    public void userClickButtonAddToCartInFirstListProduct() throws InterruptedException {
        drivers.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(500);
    }

    @And("user click icon cart")
    public void userClickIconCart() throws InterruptedException {
        drivers.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(500);
    }

    @Then("in cart page, will show product user which choose")
    public void inCartPageWillShowProductUserWhichChoose() {
        Assert.assertEquals("Sauce Labs Backpack",drivers.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Adding product to cart");
        System.out.println("If Success Add Product to Cart " + drivers.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + " , You Can See Title Product Name " + drivers.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + "  in Cart Page");
        drivers.quit();
    }


}
