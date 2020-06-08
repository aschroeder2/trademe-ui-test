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
    public void countMakes(int expectedMakesCount) {
        Assert.assertEquals(expectedMakesCount, searchUsedCars.availableMakesCount())
    }
}
