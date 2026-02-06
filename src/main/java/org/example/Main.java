package org.example;
import org.example.entity.Account;
import org.example.entity.Customer;
import org.example.entity.Transaction;
import org.example.service.AccountService;
import org.example.service.TransactionService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.Scanner;
/*
Execution Order (very important)
createCustomer
addBranch
openAccount
deposit
withdraw
transfer
Queries / reports
Card features
 */

public class Main {
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
            accountService.openAccount(1);
            accountService.openAccount(1);
            transactionService.deposit(1,1000);
            transactionService.withdraw(1,500);
            transactionService.transfer(1,2,700);

    }
}
