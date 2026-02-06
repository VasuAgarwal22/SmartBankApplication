package org.example.entity;

import jakarta.persistence.*;

@Entity
public class CardATM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNumber;
    private String ExpiryDate;
    private int CVV;
    private int Pin;
    private String Status;

    @OneToOne
    private Account account;

    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getCVV() {
        return CVV;
    }
    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
    public String getExpiryDate() {
        return ExpiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }
    public int getPin() {
        return Pin;
    }
    public void setPin(int pin) {
        Pin = pin;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CardATM{" +
                "cardNumber=" + cardNumber +
                ", ExpiryDate='" + ExpiryDate + '\'' +
                ", CVV=" + CVV +
                ", Pin=" + Pin +
                ", Status='" + Status + '\'' +
                '}';
    }
}
