package service;


import account.Account;
import account.Clock;
import account.TransactionRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceStepDefs {
    private Clock clock = new Clock();
    private TransactionRepository transactionRepository = new TransactionRepository(clock);

    private Account account = new Account(transactionRepository);

    /**
     * i_deposit.
     *
     * @param deposit
     */
    @Given("^I deposit (\\d+) euros$")
    public void i_deposit(double amount) {
        account.deposit(amount);
    }
    /**
     * i_print_the_statement.
     *
     */
    @When("^I print the statement$")
    public void i_print_the_statement() {
        //account.printStatement(System.out);
    }

    /**
     * my_balance_should_be.
     *
     * @param expectedBalance
     */
    @Then("^My balance should be (-?\\d+)")
    public void my_balance_should_be(double expectedBalance) {
       // assertEquals(expectedBalance, account.getBalance(), 0);
    }
}
