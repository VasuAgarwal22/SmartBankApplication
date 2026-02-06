package org.example.service;

import org.example.HibernateUtil;
import org.example.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerSevice {
    Session session = HibernateUtil.getSessionFactory().openSession();
//    public void createCustomer(Customer customer){
//
//    }
//    public Customer getCustomerById(int customerId){
//
//    }
//    public List<Customer> getAllCustomers(){
//
//    }
//    public void updateCustomerContact(int id,String phone, String email){
//
//    }
}
