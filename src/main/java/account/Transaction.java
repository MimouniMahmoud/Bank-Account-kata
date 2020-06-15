package account;

import service.BankOperation;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final String date;
    private final int amount;
    private BankOperation typeOperation;

    Transaction(String date, int amount,BankOperation typeOperation){

        this.date = date;
        this.amount = amount;
        this.typeOperation = typeOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return  that.amount == amount&&
                (date!=null ? date.equals(that.date) : that.date != null) &&
                typeOperation == that.typeOperation;
    }

    @Override
    public int hashCode() {
      int  result =  31 * (date!=null ?date.hashCode():0) + amount + (typeOperation!= null ?typeOperation.hashCode():0);
        return result;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public BankOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(BankOperation typeOperation) {
        this.typeOperation = typeOperation;
    }
}
