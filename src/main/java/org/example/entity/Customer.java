package org.example.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int customerId;
   private String firstName;
   private String lastName;
   private String dob;
   private String Gender;
   private String PhoneNumber;
   private String email;
   private String Address;
   private String AadhaarNumber;
   private LocalDateTime createdAt;
   @OneToMany(mappedBy = "customer")
   private List<Account> accounts;

    public String getAadhaarNumber() {
        return AadhaarNumber;
    }
    public void setAadhaarNumber(String aadhaarNumber) {
        AadhaarNumber = aadhaarNumber;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "AadhaarNumber='" + AadhaarNumber + '\'' +
                ", customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", Gender='" + Gender + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }


}