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

public class Sorting {
    WebDriver driver;
    @Given("User should be login in saucedemo for sorting")
    public void userShouldBeLoginInSaucedemoForSorting() throws InterruptedException {
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

    @When("user click Name  \\(A to Z) in top right of page")
    public void userClickNameAToZInTopRightOfPage() throws InterruptedException {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(500);
    }

    @And("user choose price \\(low to highr)")
    public void userChoosePriceLowToHighr() throws InterruptedException {
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
        Thread.sleep(500);
    }

    @Then("will display list product in home page will sorting based on price low to high")
    public void willDisplayListProductInHomePageWillSortingBasedOnPriceLowToHigh() {
        Assert.assertEquals("$7.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        System.out.println("Scenario : choose price (low to high)");
        System.out.println("If Success Sorting Price Low to High, You Can See Firt Product Will See Price " + driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        driver.quit();
    }
}
