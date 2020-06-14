package account;

public class Account {
    private TransactionRepository transactionRepository;


    public Account(TransactionRepository transactionRepository){
        this.transactionRepository= transactionRepository;
    }

    public void deposit(double amount) {
       this.transactionRepository.addDeposit(amount);
    }
}
