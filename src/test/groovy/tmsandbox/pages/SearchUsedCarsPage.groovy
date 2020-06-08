package tmsandbox.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class SearchUsedCarsPage {
    WebDriver driver

    SearchUsedCarsPage (WebDriver driver) {
        this.driver = driver
    }

    int availableMakesCount() {
        List<WebElement> makesTableLinks = driver.findElements(By.cssSelector('table#makeTable a'))

        return makesTableLinks.size()
    }
}
