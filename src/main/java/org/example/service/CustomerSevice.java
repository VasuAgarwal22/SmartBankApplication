package org.example.service;
import org.example.HibernateUtil;
import org.example.entity.Customer;
import org.hibernate.Session;
import java.util.List;

public class CustomerSevice {

    public void createCustomer(Customer customer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try {
            session.persist(customer);
            txn.commit();
            System.out.println("Customer created with ID " + customer.getCustomerId());
        } catch (Exception e) {
            txn.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    public Customer getCustomerById(int customerId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class,getCustomerById(customerId));
        session.close();
        return customer;
    }

    public List<Customer> getAllCustomers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
        session.close();
        return customers;
    }

    public void updateCustomerContact(int id,String phone, String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();
        try {
            Customer customer = session.get(Customer.class,getCustomerById(id));
            if(customer == null){
                throw  new RuntimeException("Customer not found");
            }
            customer.setPhoneNumber(phone);
            customer.setEmail(email);
            txn.commit();
        }catch (Exception e){
            txn.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

}
