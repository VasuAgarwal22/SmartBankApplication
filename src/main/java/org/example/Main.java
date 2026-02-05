package org.example;
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
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        System.out.println("|| Welcome to the Banking App..|| Add the details of yourself ");
        System.out.println("It should be in order of :-->");
        System.out.println("Enter the first Name");
        System.out.println("Enter Last Name");
        System.out.println("Enter date of birth Note Enter date OF birth in format of dd/mm/yyyy");
        System.out.println("Enter your gender");
        System.out.println("Enter the phone Number");
        System.out.println("Enter the valid email ");
        System.out.println("Enter the Address");
        System.out.println("Enter the AadhaarNumber of the customer");
        System.out.println();
        Scanner sc = new Scanner(System.in);

        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        String DOB = sc.nextLine();
        String Gender = sc.nextLine();
        String PhoneNumber = sc.nextLine();
        String email = sc.nextLine();
        String Address = sc.nextLine();
        String AadhaarNumber = sc.nextLine();


        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setDob(DOB);
        customer.setGender(Gender);
        customer.setPhoneNumber(PhoneNumber);
        customer.setEmail(email);
        customer.setAddress(Address);
        customer.setAadhaarNumber(AadhaarNumber);
        customer.setCreatedAt(LocalDateTime.now());

        
        Account account = new Account();
        account.setAccountNumber(101);
        account.setAccountType("SAVINGS");
        account.setBalance(10_000);
        account.setStatus("ACTIVE");
        account.setCreatedAt(LocalDateTime.now());


        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(customer);
//        session.persist(account);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }
}
