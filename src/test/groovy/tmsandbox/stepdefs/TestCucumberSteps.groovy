package tmsandbox.stepdefs

import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import org.junit.Assert;

class TestCucumberSteps {

    private int result;

    @When('I add {int} + {int}')
    public void addTwoNumbers(int firstNumber, int secondNumber) {

        result = firstNumber + secondNumber;
    }

    @Then('the result is {int}')
    public void returnArithmeticResult(int expectedResult) {

        Assert.assertEquals(expectedResult, result);
    }
}
