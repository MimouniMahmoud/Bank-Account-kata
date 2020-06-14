package account;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import service.BankOperation;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

public class AccountTest {

    @Mock
    private TransactionRepository transactionRepository;
    private Account account ;

    @Before
    public void initialize(){
        account = new Account(transactionRepository);
    }

    @Test
    public void store_a_deposit_transaction(){
        account.deposit(100);

        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void print_a_statement(){
        List<Transaction> transactions = Arrays.asList(new Transaction("14/06/2020",100, BankOperation.DEPOSIT));
        BDDMockito.given(transactionRepository.allTransaction()).willReturn(transactions);

    }
}
