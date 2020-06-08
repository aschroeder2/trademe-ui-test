package tmsandbox.stepdefs

import com.google.inject.Inject
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import org.junit.Assert
import tmsandbox.pages.SearchUsedCarsPage

@ScenarioScoped
class UsedCarsSteps {
    @Inject World world

    SearchUsedCarsPage searchUsedCars

    @Before
    void setUpPages() {
        searchUsedCars = new SearchUsedCarsPage(world.driver)
    }

    @Then('^there are (\\d+) available used car brands$')
    void countMakes(int expectedMakesCount) {
        Assert.assertEquals(expectedMakesCount, searchUsedCars.availableMakesCount())
    }

    @Then('^the (.+) brand has availability$')
    void validateMakeAvailable(make) {
        Assert.assertTrue(searchUsedCars.makeAvailable(make))
    }

    @Then('^there is (\\d+) (.+) brand vehicle available$')
    void validateAvailableMakeCount(int expectedCount, make) {
        Assert.assertEquals(expectedCount, searchUsedCars.countAvailableCarsByMake(make))
    }

    @Then('^the unavailable brand (.+) is not displayed$')
    void validateMakeNotDisplayed(unavailableMake) {
        List availableMakes = searchUsedCars.availableMakes()

        Assert.assertFalse(availableMakes.contains(unavailableMake))

    }
}
