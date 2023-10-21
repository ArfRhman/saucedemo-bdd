package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
    WebDriver drivers;
    @Given("User should be login in saucedemo")
    public void userShouldBeLoginInSaucedemo() throws InterruptedException {
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

    @When("I click burger button")
    public void iClickBurgerButton() throws InterruptedException {
        drivers.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("I click logout link")
    public void iClickLogoutLink() {
        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(drivers, 10);

        // Wait for element to be clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        // Perform an action on the element
        element.click();
    }

    @Then("I go to login page")
    public void iGoToLoginPage() {
        drivers.findElement(By.id("login-button")).isDisplayed();
        drivers.close();
        drivers.quit();
    }


}
