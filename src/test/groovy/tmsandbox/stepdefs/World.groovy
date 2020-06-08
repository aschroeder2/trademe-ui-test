package tmsandbox.stepdefs

import io.cucumber.guice.ScenarioScoped
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.yaml.snakeyaml.Yaml

@ScenarioScoped
class World {

    WebDriver driver
    Map<String, Object> testProperties

    World() {
        this.driver = setUpDriver()
        this.testProperties = loadTestProperties()
    }

    WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup()
        driver = new ChromeDriver()

        return driver
    }

    Map<String, Object> loadTestProperties() {
        Yaml yaml = new Yaml()
        InputStream file = this.getClass().getClassLoader()
                .getResourceAsStream("properties/test_properties.yaml")

        Map<String, Object> properties = yaml.load(file)

        return properties
    }
}
