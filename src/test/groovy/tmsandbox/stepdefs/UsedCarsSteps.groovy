package tmsandbox.stepdefs

import com.google.inject.Inject
import groovy.util.logging.Slf4j
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import org.junit.Assert
import tmsandbox.pages.SearchUsedCarsPage

@ScenarioScoped
@Slf4j
class UsedCarsSteps {
    @Inject World world

    SearchUsedCarsPage searchUsedCars

    @Before
    void setUpPages() {
        searchUsedCars = new SearchUsedCarsPage(world.driver)
    }

    @Then('^there are (\\d+) available used car brands$')
    void countMakes(int expectedMakesCount) {
        int availableMakesCount = searchUsedCars.availableMakesCount()

        log.info('The available make count is: ' + availableMakesCount)
        Assert.assertEquals(expectedMakesCount, availableMakesCount)
    }

    @Then('^the (.+) brand has availability$')
    void validateMakeAvailable(make) {
        Assert.assertTrue(searchUsedCars.makeAvailable(make))
    }

    @Then('^there is (\\d+) (.+) brand vehicle available$')
    void validateAvailableMakeCount(int expectedCount, make) {
        int specificMakeCount = searchUsedCars.countAvailableCarsByMake(make)

        log.info(make + 'availability count is: ' + specificMakeCount.toString())
        Assert.assertEquals(expectedCount, specificMakeCount)
    }

    @Then('^the unavailable brand (.+) is not displayed$')
    void validateMakeNotDisplayed(unavailableMake) {
        List availableMakes = searchUsedCars.availableMakes()

        log.info('The currently available makes are: ' + availableMakes.toString())
        Assert.assertFalse(availableMakes.contains(unavailableMake))
    }
}
