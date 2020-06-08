package tmsandbox.stepdefs

import groovy.util.logging.Slf4j
import io.cucumber.guice.ScenarioScoped
import com.google.inject.Inject
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import tmsandbox.pages.HomePage

@ScenarioScoped
@Slf4j
class HomeSteps {
    @Inject World world

    HomePage homePage

    @Before
    void setUpPages() {
        homePage = new HomePage(world.driver)
    }

    @When('^I navigate to the (.+)$')
    public void navigateToTradeMePage(page) {
        String url = world.testProperties[page]

        log.info('Navigating to page: ' + url)
        world.driver.get(url)
    }

    @Then('^the homepage loads successfully$')
    public void validateHomePage() {
        Assert.assertTrue(homePage.homepageLogoDisplayed())
    }
}
