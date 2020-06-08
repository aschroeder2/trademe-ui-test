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

        return makesTableLinks().size()
    }

    boolean makeAvailable(String make) {
        for (WebElement makeLink : makesTableLinks()) {
            String availableMakeName = makeLink.getText()

            if (availableMakeName == make) {

                return true
            }
        }

        return false
    }

    int countAvailableCarsByMake(String make) {
        List<WebElement> makesTableCellElems = driver.findElements(By.cssSelector('table#makeTable td *'))
        int specifiedMakeCarCount

        for (WebElement cell : makesTableCellElems) {
            String cellText = cell.getText()

            if (cellText == make) {
                int makeCellIndex = makesTableCellElems.indexOf(cell)
                specifiedMakeCarCount = makesTableCellElems[makeCellIndex + 1].getText()
                    .replaceAll('\\(', '').replaceAll('\\)', '').toInteger()
            }
        }

        return specifiedMakeCarCount
    }

    List availableMakes() {
        List availableMakes = []

        for (WebElement makeLink : makesTableLinks()) {
            String availableMakeName = makeLink.getText()
            availableMakes.add(availableMakeName)
        }

        return availableMakes
    }

    private List<WebElement> makesTableLinks() {
        List<WebElement> makesTableLinks = driver.findElements(By.cssSelector('table#makeTable a'))

        return makesTableLinks
    }
}
