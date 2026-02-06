package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int txnId;
    private String txnType;
    private double Amount;
    private LocalDateTime DateTime;
    private String Remarks;
    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    public double getAmount() {
        return Amount;
    }
    public void setAmount(double amount) {
        Amount = amount;
    }
    public LocalDateTime getDateTime() {
        return DateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        DateTime = dateTime;
    }
    public String getRemarks() {
        return Remarks;
    }
    public void setRemarks(String remarks) {
        Remarks = remarks;
    }
    public int getTxnId() {
        return txnId;
    }
    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }
    public String getTxnType() {
        return txnType;
    }
    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Amount=" + Amount +
                ", txnId=" + txnId +
                ", txnType='" + txnType + '\'' +
                ", DateTime=" + DateTime +
                ", Remarks='" + Remarks + '\'' +
                '}';
    }
}
