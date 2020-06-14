package account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.BankOperation;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock TransactionRepository transactionRepository;
    private Account account ;

    @Before
    public void initialize(){
        this.account = new Account(this.transactionRepository);
    }

    @Test
    public void store_a_deposit_transaction(){
        this.account.deposit(100);
        verify(this.transactionRepository).addDeposit(100);
    }

    @Test
    public void store_a_withdrawal_transaction(){
        this.account.withdraw(100);
        verify(this.transactionRepository).addWithdraw(100);
    }
}
