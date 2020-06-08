package tmsandbox.stepdefs

import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.Assert
import org.junit.BeforeClass
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class HomeSteps {

    private WebDriver driver

//    @BeforeClass
//    void setUpDriver() {
//        WebDriverManager.chromedriver().setup()
//    }

    @Before
    void setUpWebDriver() {
        WebDriverManager.chromedriver().setup()
        driver = new ChromeDriver()
    }

    @After
    void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies()
            driver.quit()
        }
    }

    @When('I navigate to the TradeMe homepage')
    public void navigateToTradeMePage() {
        driver.get('https://www.tmsandbox.co.nz/')
    }

    @Then('the homepage loads successfully')
    public void validateHomePage() {
        WebElement homepageLogo = driver.findElement(By.id('SiteHeader_SiteTabs_kevin'))

        Assert.assertTrue(homepageLogo.isDisplayed())
    }
}
