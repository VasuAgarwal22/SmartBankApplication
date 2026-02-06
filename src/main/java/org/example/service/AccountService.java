package org.example.service;
import org.example.entity.Customer;
import org.example.HibernateUtil;
import org.example.entity.Account;
import org.hibernate.Session;
//import java.util.Collections;
import java.util.List;

public class AccountService {
    public void openAccount(int customerId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Customer customer = session.get(Customer.class, customerId);
            if (customer == null) {
                throw new RuntimeException("Customer not found");
            }
            Account acc = new Account();
            acc.setAccountType("SAVINGS");
            acc.setBalance(0);
            acc.setStatus("ACTIVE");
            acc.setCreatedAt(java.time.LocalDateTime.now());
            acc.setCustomer(customer);
            session.persist(acc);
            tx.commit();
            System.out.println(" Account created successfully. Account Number: " + acc.getAccountNumber());
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Account getAccountByNumber(int AccountNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = session.get(Account.class,getAccountByNumber(AccountNumber));
        session.close();
        return account;
    }

    public List<Account> getAccountsOfCustomer(int customerId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class,getAccountsOfCustomer(customerId));
        if(customer == null){
            throw  new RuntimeException("No customer found");
        }
        List<Account> accounts = customer.getAccounts();
        accounts.size();
        session.close();
        return accounts;
    }

    public void blockAccount(int AccountNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try {
            Account account = session.get(Account.class,getAccountByNumber(AccountNumber));
            if(account == null) throw new RuntimeException("Account not Found");
            account.setStatus("BLOCKED");
            txn.commit();
        }catch (Exception e){
            txn.rollback();
            throw e;
        }finally {
        session.close();
        }
    }

    public void closeAccount(int AccountNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try {
            Account account = session.get(Account.class,getAccountByNumber(AccountNumber));
            if(account==null) throw new RuntimeException("No account Found");
            account.setStatus("CLOSED");
            txn.commit();
        } catch (Exception e) {
            txn.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

}
