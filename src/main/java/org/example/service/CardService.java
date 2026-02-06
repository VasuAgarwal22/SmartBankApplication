package org.example.service;

import org.example.HibernateUtil;
import org.example.entity.Account;
import org.example.entity.CardATM;
import org.hibernate.Session;

public class CardService {

    public void issueCard(int AccountNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try {
            Account account = session.get(Account.class,getCardByAccount(AccountNumber));
            if(account == null) throw new RuntimeException("Account new Found");
            if(account.getCardATM()!=null) throw new RuntimeException("Card already exist");
            CardATM card = new CardATM();
            card.setAccount(account);
            card.setPin(1234);
            card.setCVV(111);
            card.setExpiryDate("12/30");
            card.setStatus("ACTIVE");
            txn.commit();
        }catch (Exception e){
            txn.rollback();
            throw e;
        }finally {
        session.close();
        }
    }

    public CardATM getCardByAccount(int AccountNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account acc = session.get(Account.class, AccountNumber);
        if (acc == null) {
            session.close();
            throw new RuntimeException("Account not found");
        }
        CardATM card = acc.getCardATM();
        session.close();
        return card;
    }

    public void changePIN(int cardNumber,int newPin){
        Session session =HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try {
            CardATM cardATM = session.get(CardATM.class,cardNumber);
            if(cardATM==null) throw new RuntimeException("card does not found!!");
            cardATM.setPin(newPin);
            txn.commit();
        }catch (Exception e){
            txn.rollback();
            throw e;
        }finally {
            session.close();
        }
    }


    public void blockCard(int cardNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try {
            CardATM cardATM = session.get(CardATM.class,cardNumber);
            if(cardATM == null) throw new RuntimeException("card does not exist");
            cardATM.setStatus("BLOCKED SUCCESSFULLY");
            txn.commit();
        }catch (Exception e){
            txn.rollback();
        }finally {
            session.close();
        }
    }



}
