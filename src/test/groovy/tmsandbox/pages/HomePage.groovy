package tmsandbox.pages

import groovy.util.logging.Slf4j
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

@Slf4j
class HomePage {

    WebDriver driver

    HomePage(WebDriver driver) {
        this.driver = driver
    }

    boolean homepageLogoDisplayed() {
        WebElement homepageLogo = driver.findElement(By.id('SiteHeader_SiteTabs_kevin'))

        return homepageLogo.isDisplayed()
    }
}
