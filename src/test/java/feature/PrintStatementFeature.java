package feature;

import account.Account;
import account.Clock;
import account.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    private Account account;
    @Mock
    private Clock clock;

    @Before
    public void initialize(){
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        this.account = new Account(transactionRepository);
    }
    
    
    @Test
    public void print_statement_containing_all_transactions(){
        account.deposit(100);


    }
}
