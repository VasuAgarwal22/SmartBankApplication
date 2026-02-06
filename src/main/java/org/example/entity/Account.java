package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AccountNumber;
    private String AccountType;
    private double balance;
    private String Status;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    @OneToOne(mappedBy = "account")
    private CardATM cardATM;

    public int getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }
    public String getAccountType() {
        return AccountType;
    }
    public void setAccountType(String accountType) {
        AccountType = accountType;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public CardATM getCardATM() {
        return cardATM;
    }

    public void setCardATM(CardATM cardATM) {
        this.cardATM = cardATM;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber=" + AccountNumber +
                ", AccountType='" + AccountType + '\'' +
                ", balance=" + balance +
                ", Status='" + Status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}