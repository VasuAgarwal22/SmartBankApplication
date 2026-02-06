package org.example;
//import org.example.entity.Account;
import org.example.entity.Customer;
import org.example.entity.Transaction;
import org.example.service.AccountService;
import org.example.service.CardService;
import org.example.service.CustomerSevice;
import org.example.service.TransactionService;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;
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
        Scanner sc = new Scanner(System.in);
        AccountService accountService = new AccountService();
        CardService cardService = new CardService();
        CustomerSevice customerSevice = new CustomerSevice();
        TransactionService transactionService = new TransactionService();

        while (true) {
            System.out.println("=================");
            System.out.println("1. Create Customer");
            System.out.println("2. Open Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. View Transactions");
            System.out.println("7. Issue ATM Card");
            System.out.println("8. Change ATM PIN");
            System.out.println("9. Block ATM Card");
            System.out.println("10. Exit");

            System.out.print("Enter Choice: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(" Invalid input. Enter a number.");
                continue;
            }
            switch (choice) {
                case 1 -> createCustomerUI(sc, customerSevice);
                case 2 -> openAccountUI(sc, accountService);
                case 3 -> depositUI(sc, transactionService);
                case 4 -> withdrawUI(sc, transactionService);
                case 5 -> transferUI(sc, transactionService);
                case 6 -> viewTransactionsUI(sc, transactionService);
                case 7 -> issueCardUI(sc, cardService);
                case 8 -> changeAtmUI(sc, cardService);
                case 9 -> blockAtmUI(sc, cardService);
                case 10 -> {
                    System.out.println(" Thank you for using SmartBankApp");
                    sc.close();
                    return;
                }
                default -> System.out.println(" Invalid choice. Try again.");
            }
        }
    }
    private static void blockAtmUI(Scanner sc, CardService cardService) {
        System.out.print("Card Number: ");
        int card = sc.nextInt();
        cardService.blockCard(card);
        System.out.println("Card blocked");
    }
    private static void changeAtmUI(Scanner sc, CardService cardService) {
        System.out.println("Enter the card Number");
        int card = sc.nextInt();
        System.out.println("Enter the new Pin");
        int pin = sc.nextInt();
        cardService.changePIN(card,pin);
        System.out.println("Pin updated Successfully");
    }
    private static void issueCardUI(Scanner sc, CardService cardService) {
        System.out.println("Enter the account Number : ");
        int acc = sc.nextInt();
        cardService.issueCard(acc);
        System.out.println("========================================");
        System.out.println("Card Issued Successfully");
        System.out.println("========================================");

    }
    private static void viewTransactionsUI(Scanner sc, TransactionService transactionService) {
        System.out.println("Account Number :");
        int acc = sc.nextInt();
        List<Transaction> transactions = transactionService.getTransactionsByAccount(acc);
        if(transactions.isEmpty()){
            System.out.println("There are no transactions for this account");
        }else{
            System.out.println("Transactions :");
            for(Transaction t : transactions){
                System.out.println(t);
            }
        }
    }
    private static void transferUI(Scanner sc, TransactionService transactionService) {
        System.out.println("From account : ");
        int from = sc.nextInt();
        System.out.println("To account : ");
        int to = sc.nextInt();
        System.out.println("Enter the amount to transfer :");
        double amount = sc.nextDouble();
        transactionService.transfer(from,to,amount);
    }
    private static void withdrawUI(Scanner sc, TransactionService transactionService) {
        System.out.println("Enter the Account Number : ");
        int acc = sc.nextInt();
        System.out.println("Enter the Amount that you want to withdraw : ");
        double amount = sc.nextDouble();
        transactionService.withdraw(acc,amount);
        System.out.println("========================================");
        System.out.println("Withdrawn Successfully !!");
        System.out.println("========================================");
    }
    private static void depositUI(Scanner sc, TransactionService transactionService) {
        System.out.println("Enter the Account Number : ");
        int acc = sc.nextInt();
        System.out.println("Enter the Amount that you want to deposit : ");
        double amount = sc.nextDouble();
        transactionService.deposit(acc,amount);
        System.out.println("========================================");
        System.out.println("Deposit Successfully !!");
        System.out.println("========================================");
    }
    private static void openAccountUI(Scanner sc, AccountService accountService) {
        System.out.println("Enter Your CustomerId : ");
        int id = sc.nextInt();
        accountService.openAccount(id);
//        System.out.println("Account Opened successfully with ID : "); it is already done in accountService no need to worry
    }
    public static void createCustomerUI(Scanner sc,CustomerSevice customerSevice){
        Customer customer = new Customer();
        System.out.println("Enter the First Name : ");
        customer.setFirstName(sc.nextLine());
        System.out.println("Enter the Last Name : ");
        customer.setLastName(sc.nextLine());
        System.out.println("Enter the DateOfBirth : ");
        customer.setDob(sc.nextLine());
        System.out.println("Enter the Gender : ");
        customer.setGender(sc.nextLine());
        System.out.println("Enter the Contact Number : ");
        customer.setPhoneNumber(sc.nextLine());
        System.out.println("Enter the email : ");
        customer.setEmail(sc.nextLine());
        System.out.println("Enter the Address : ");
        customer.setAddress(sc.nextLine());
        System.out.println("Enter the Aadhaar Number : ");
        customer.setAadhaarNumber(sc.nextLine());
        customer.setCreatedAt(LocalDateTime.now());
        customerSevice.createCustomer(customer);
        System.out.println("========================================");
        System.out.println("Customer created with ID" + customer.getCustomerId());
        System.out.println("========================================");

    }
}
