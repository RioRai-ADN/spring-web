/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Customer;
import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Rio.Rai
 */
public class CustomerService {
    
    /**
     * lay danh sach khach hang da mua san pham
     * @return 
     */
    public ArrayList<Customer> getAllCustomer() {
    
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from customer");
        
        ArrayList<Customer> customerList = (ArrayList<Customer>) query.list();
        transaction.commit();
        
        return customerList;
    }
    
    /**
     * them 1 khach hang
     * @param customer
     * @return 
     */
    public boolean insertCustomer(Customer customer) {
    
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public static void main(String args[]) {
    
        System.out.println(new CustomerService().getAllCustomer());
    }
}
