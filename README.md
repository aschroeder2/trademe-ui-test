# trademe-ui-test
This is a sample UI test automation project testing against the TradeMe sandbox web site (https://www.tmsandbox.co.nz/). The project is written in Groovy, uses Gradle for as the build tool, and Cucumber, Selenium WebDriver, and JUnit assertions for testing.


## Prerequisites
In order to run the project, the following needs to be installed and added to local system variables.
```
Java 1.8
Groovy 3.0.4
Gradle 6.5
```

## Running the tests
Currently the project is configured to restrict scenarios with the tags argument in the build.gradle file.
To run the tests:

```
gradle cucumber
```

## View test results
After running the tests, you can view the results under the /build/reports/cucumber directory. The report file is index.html.
