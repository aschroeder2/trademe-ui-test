package tmsandbox.stepdefs

import com.google.inject.Inject
import io.cucumber.java.After

class Hooks {
    @Inject World world

    @After
    void tearDown() {
        if (world.driver != null) {
            world.driver.manage().deleteAllCookies()
            world.driver.quit()
        }
    }
}
