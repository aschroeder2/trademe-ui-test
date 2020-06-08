package tmsandbox.stepdefs

import io.cucumber.guice.ScenarioScoped
import com.google.inject.Inject
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import tmsandbox.pages.HomePage

@ScenarioScoped
class HomeSteps {
    @Inject World world

    HomePage homePage

    @Before
    void setUpPages() {
        homePage = new HomePage(world.driver)
    }

    @When('^I navigate to the (.+)$')
    public void navigateToTradeMePage(page) {
        world.driver.get(world.testProperties[page])
    }

    @Then('^the homepage loads successfully$')
    public void validateHomePage() {
        Assert.assertTrue(homePage.homepageLogoDisplayed())
    }
}
