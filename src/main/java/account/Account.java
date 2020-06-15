package account;

public class Account {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter ;

    public Account(TransactionRepository transactionRepository,
                   StatementPrinter statementPrinter){
        this.transactionRepository= transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
       this.transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        this.transactionRepository.addWithdraw(amount);
    }

    public void printStatement(){
        statementPrinter.print(transactionRepository.allTransaction());
    }
}
