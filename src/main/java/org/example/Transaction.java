package org.example;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int txnId;
    private String txnType;
    private int Amount;
    private LocalDateTime DateTime;
    private String Remarks;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "")

    public int getAmount() {
        return Amount;
    }
    public void setAmount(int amount) {
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
