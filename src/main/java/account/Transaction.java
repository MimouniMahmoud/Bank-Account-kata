package account;

import service.BankOperation;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private double balance;
    private final String date;
    private final double amount;
    private BankOperation typeOperation;

    Transaction(String date, double amount,BankOperation typeOperation){

        this.date = date;
        this.amount = amount;
        this.typeOperation = typeOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.balance, balance) == 0 &&
                Double.compare(that.amount, amount) == 0 &&
                (date!=null ? date.equals(that.date) : that.date != null) &&
                typeOperation == that.typeOperation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, date, amount, typeOperation);
    }
}
