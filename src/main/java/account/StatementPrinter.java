package account;

import service.BankOperation;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    public static final String STATEMENT_HEADER = "|Operation|Date|Amount|Balance|";
    private Console console ;

    public StatementPrinter(Console console){
        this.console = console;
    }



    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);
        printStatementLies(transactions);
    }

    private void printStatementLies(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        transactions.stream()
                    .map(transaction->statementLine(transaction,runningBalance))
                    .collect(Collectors.toCollection(LinkedList::new))
                    .descendingIterator()
                    .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        stringBuilder.append(transaction.getTypeOperation());
        stringBuilder.append("|");
        stringBuilder.append(transaction.getDate());
        stringBuilder.append("|");
        stringBuilder.append(transaction.getAmount());
        stringBuilder.append("|");
        stringBuilder.append(runningBalance.accumulateAndGet(transaction.getAmount(),
                (transaction.getTypeOperation().equals(BankOperation.DEPOSIT))?((x,y)->x+y):((x,y)->x-y)));
        stringBuilder.append("|");
       return stringBuilder.toString();
    }
}
