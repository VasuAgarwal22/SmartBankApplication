package org.example.service;
import org.example.entity.Account;
//import org.hibernate.Transaction;
import org.example.entity.Transaction;
import org.example.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionService {

    public void deposit(int AccountNumber,double amount){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx =  session.beginTransaction();
        try {
            Account acc = session.get(Account.class,AccountNumber);
            if(acc == null){
                throw  new RuntimeException("Account not Found");
            }
            acc.setBalance((acc.getBalance()+amount));
            Transaction txn = new Transaction();
            txn.setAmount(amount);
            txn.setTxnType("DEPOSIT");
            txn.setDateTime(LocalDateTime.now());
            txn.setAccount(acc);
            session.persist(txn);
            tx.commit();

        }
        catch (Exception e){
        tx.rollback();
        }
        finally {
            session.close();
        }
    }

    public void withdraw(int AccountNumber,double amount){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();

        try{
            Account acc = session.get(Account.class,AccountNumber);
            if(acc == null){
                throw new RuntimeException("Account not Found");
            }
            if(amount>acc.getBalance()){
                throw  new RuntimeException("Insufficient Balance");
            }else{
                acc.setBalance(acc.getBalance()-amount);
            }
            Transaction tx = new Transaction();
            tx.setAmount(amount);
            tx.setTxnType("WITHDRAW");
            tx.setDateTime(LocalDateTime.now());
            tx.setAccount(acc);

            session.persist(tx);
            txn.commit();
        }catch (Exception e){
        txn.rollback();
        }finally {
            session.close();
        }
    }

    public void transfer(int fromAcc,int toAcc,double amount){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try{
            Account from = session.get(Account.class,fromAcc);
            Account to = session.get(Account.class,toAcc);

            if(from == null || to == null){
                throw new RuntimeException("Account not Found");
            }

            if(from.getBalance()<amount){
                throw new RuntimeException("Insufficient Balance");
            }
            else{
                from.setBalance(from.getBalance()-amount);
                to.setBalance(to.getBalance()+amount);

                Transaction t1 = new Transaction();
                t1.setAmount(amount);
                t1.setTxnType("DEBIT");
                t1.setDateTime(LocalDateTime.now());
                t1.setAccount(from);

                Transaction t2 = new Transaction();
                t2.setAmount(amount);
                t2.setTxnType("CREDIT");
                t2.setDateTime(LocalDateTime.now());
                t2.setAccount(to);
                session.persist(t1);
                session.persist(t2);
            }
            txn.commit();
        }catch (Exception e ){
            txn.rollback();
        }finally {
            session.close();
        }
    }

    public List<Transaction> getTransactionsByAccount(int AccountNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account acc = session.get(Account.class,AccountNumber);
        List<Transaction> transactions = acc.getTransactions();
        transactions.size();
        session.close();
        return transactions;

    }
}
