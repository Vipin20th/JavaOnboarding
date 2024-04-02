package BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithdrawCashStepDefinitions {

    private Account account;

    @Given("I have a balance of ${int} in my account")
    public void iHaveABalanceOf$InMyAccount(int balance) {
        account = new Account(balance);
    }

    @When("I request ${int}")
    public void iRequest$(int amount) {
        account.withdraw(amount);
    }

    @Then("${int} should be dispensed")
    public void $ShouldBeDispensed(int amount) {
        if (account.getBalance() == amount) {
            System.out.println("$" + amount + " dispensed successfully");
        } else {
            System.out.println("Error: Incorrect amount dispensed");
        }
    }
}
