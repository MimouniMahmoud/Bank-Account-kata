package feature;

import account.Account;
import account.Clock;
import account.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class PrintStatementFeature {

    private Account account;
    @Mock
    private Clock clock;

    @Before
    public void initialize(){
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        account = new Account(transactionRepository);
    }
    
    
    @Test
    public void print_statement_containing_all_transactions(){
        account.deposit(100);


    }
}
