package account;


import static org.assertj.core.api.Assertions.assertThat;
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
        BDDMockito.given(clock.toDayAsString()).willReturn(TODAY);
    }
    @Test
    public void create_and_store_a_deposit_transaction(){
        transactionRepository.addDeposit(100);
        List<Transaction> transactions = transactionRepository.allTransaction();
        assertThat(transactions.size()).isEqualTo(1);
        assertThat(transactions.get(0)).isEqualTo((transaction(TODAY,100,BankOperation.DEPOSIT)));
    }


    @Test
    public void create_and_store_a_withdrawal_transaction(){
        transactionRepository.addWithdraw(100);
        List<Transaction> transactions = transactionRepository.allTransaction();
        assertThat(transactions.size()).isEqualTo(1);
        assertThat(transactions.get(0)).isEqualTo(transaction(TODAY,100,BankOperation.WITHDRAW));
    }

    private Transaction transaction (String date , int amount, BankOperation operationType){
        return new Transaction(date,amount,operationType);
    }


}
