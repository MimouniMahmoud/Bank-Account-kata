package account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.BankOperation;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock TransactionRepository transactionRepository;
    private Account account ;
    @Mock StatementPrinter statementPrinter;

    @Before
    public void initialize(){
        this.account = new Account(this.transactionRepository,statementPrinter);
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

    @Test
    public void print_a_statement (){
        List<Transaction> transactions =Arrays.asList(new Transaction(LocalDate.now().toString(),100,BankOperation.DEPOSIT));

        BDDMockito.given(transactionRepository.allTransaction()).willReturn(transactions);
        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
