package feature;

import account.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    private Account account;
    @Mock
    private Clock clock;
    @Mock
    private Console console;

    @Before
    public void initialize(){
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        this.account = new Account(transactionRepository, statementPrinter);
    }
    
    
    @Test
    public void print_statement_containing_all_transactions(){
        given(clock.toDayAsString()).willReturn("01/06/2020","04/06/2020", "14/06/2020");

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("|Operation|Date|Amount|Balance|");
        inOrder.verify(console).printLine("|DEPOSIT|14/06/2020|500|1400|");
        inOrder.verify(console).printLine("|WITHDRAW|04/06/2020|100|900|");
        inOrder.verify(console).printLine("|DEPOSIT|01/06/2020|1000|1000|");

    }
}
