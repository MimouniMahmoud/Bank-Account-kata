package account;



import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.BankOperation;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
    public static final String TODAY = "14/06/2020";
    private TransactionRepository transactionRepository;
    @Mock
    private Clock clock;

    @Before
    public void initialise(){
        transactionRepository = new TransactionRepository(clock);
    }
    @Test
    public void create_and_store_a_deposit_transaction(){
        BDDMockito.given(clock.toDayAsString()).willReturn(TODAY);
        transactionRepository.addDeposit(100);
        List<Transaction> transactions = transactionRepository.allTransaction();
        Assert.assertThat(transactions.size(), Is.is(1));
        Assert.assertThat(transactions.get(0),Is.is(transaction(TODAY,100,BankOperation.DEPOSIT)));
    }

    private Transaction transaction (String date , double amount, BankOperation operationType){
        return new Transaction(date,amount,operationType);
    }
}
