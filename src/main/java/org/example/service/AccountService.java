package org.example.service;
import org.example.entity.Customer;
import org.example.HibernateUtil;
import org.example.entity.Account;
import org.hibernate.Session;
import java.util.List;

public class AccountService {
    public void openAccount(int customerId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);

         if(customer == null){
             throw new RuntimeException("Customer not found");
         }
            Account acc = new Account();
            acc.setAccountType("SAVINGS");
            acc.setBalance(10000);
            acc.setStatus("ACTIVE");
            acc.setCreatedAt(java.time.LocalDateTime.now());
            acc.setCustomer(customer);

            session.persist(acc);

            tx.commit();
            System.out.println("Account created with ID: " + acc.getAccountNumber());

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
//    public Account getAccountByNumber(int AccountNumber){
//
//    }
//    public List<Account> getAccountsOfCustomer(int customerId){
//
//    }
//    public void blockAccount(int AccountNumber){
//
//    }
//    public void closeAccount(int AccountNumber){
//
//    }


}
