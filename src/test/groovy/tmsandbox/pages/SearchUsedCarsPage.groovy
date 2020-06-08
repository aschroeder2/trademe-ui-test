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

    boolean makeAvailable(String make) {
        List<WebElement> makesTableLinks = driver.findElements(By.cssSelector('table#makeTable a'))

        for (WebElement makeLink : makesTableLinks) {
            String availableMakeName = makeLink.getText()

            if (availableMakeName == make) {

                return true
            }
        }

        return false
    }

    int countAvailableCarsByMake(String make) {
        List<WebElement> makesTableCells = driver.findElements(By.cssSelector('table#makeTable td'))

        for (WebElement cell : makesTableCells) {
            List<WebElement> allCellElements
        }
        0
    }

    List availableMakes() {
        List<WebElement> makesTableLinks = driver.findElements(By.cssSelector('table#makeTable a'))
        List availableMakes = []

        for (WebElement makeLink : makesTableLinks) {
            String availableMakeName = makeLink.getText()
            availableMakes.add(availableMakeName)
        }

        return availableMakes
    }
}
