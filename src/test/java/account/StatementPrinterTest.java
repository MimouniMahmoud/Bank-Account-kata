package account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import service.BankOperation;


import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {
    private static final List<Transaction> NO_TRANSACTIONS = Collections.EMPTY_LIST;
    @Mock
    private Console console;
    private StatementPrinter statementPrinter;

    @Before
    public void initialise (){
         statementPrinter = new StatementPrinter(console);
    }
    @Test
    public void always_print_header() throws IOException, ParseException {
        statementPrinter.print(NO_TRANSACTIONS);
        Mockito.verify(console).printLine("|Operation|Date|Amount|Balance|");
    }

    @Test
    public void print_transactions(){
        StatementPrinter statementPrinter = new StatementPrinter(console);
        List<Transaction> transactions = transactionsContaining(
                deposit("01/06/2020",1000),
                withdraw("04/06/2020",100),
                deposit("14/06/2020",500)
        );
        statementPrinter.print(transactions);
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("|Operation|Date|Amount|Balance|");
        inOrder.verify(console).printLine("|DEPOSIT|14/06/2020|500|1400|");
        inOrder.verify(console).printLine("|WITHDRAW|04/06/2020|100|900|");
        inOrder.verify(console).printLine("|DEPOSIT|01/06/2020|1000|1000|");


    }

    private List<Transaction> transactionsContaining(Transaction... transactions) {
        return Arrays.asList(transactions);
    }

    private Transaction deposit(String date, int amount) {
        return new Transaction(date,amount,BankOperation.DEPOSIT);
    }

    private Transaction withdraw(String date, int amount) {
        return new Transaction(date,amount,BankOperation.WITHDRAW);
    }

}
