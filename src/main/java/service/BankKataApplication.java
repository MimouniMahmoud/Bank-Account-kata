package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import account.*;

public class BankKataApplication {

    public static void main(String[] args) throws ParseException {
        Account account = new Account(new TransactionRepository(new Clock()),new StatementPrinter(new Console()));
        account.deposit(1000);
        account.withdraw(200);
        account.deposit(100);

        account.printStatement();

    }

}