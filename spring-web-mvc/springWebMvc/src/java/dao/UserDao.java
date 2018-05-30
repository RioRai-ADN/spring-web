/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Rio.Rai
 */
public class UserDao {

    /**
     * lay danh sach user
     * @return 
     */
    public ArrayList<User> getAllUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from user");
        ArrayList<User> list = (ArrayList<User>) query.list();
        transaction.commit();
        return list;
    }

    /**
     * ham dang nhap
     * @param email
     * @param password
     * @return 
     */
    public User login(String email, String password) {
    
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from user where userEmail = :email and password = :password");
            query.setString("email", email);
            query.setString("password", password);
            
            User user = (User) query.uniqueResult();
            transaction.commit();
            return user;
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String args[]) {

        System.out.println(new UserDao().login("duyanh@gmail.com", "duyanh").getUserName());
    }
}
