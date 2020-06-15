package account;


import service.BankOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private Clock clock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        transactions.add(new Transaction(clock.toDayAsString(),  amount, BankOperation.DEPOSIT));
    }

    public void addWithdraw(int amount) {
        transactions.add(new Transaction(clock.toDayAsString(),amount, BankOperation.WITHDRAW));
    }

    public List<Transaction> allTransaction() {
       return Collections.unmodifiableList(transactions);

    }
}
