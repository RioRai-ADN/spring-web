/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Provider;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Rio.Rai
 */
public class CategoryDao {
    
    /**
     * lay toan bo danh muc san pham
     * @return 
     */
    public ArrayList getAllCategories() {
    
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from category");
        
        ArrayList<Provider> listCategories = (ArrayList<Provider>) query.list();
        transaction.commit();
        
        return listCategories;
    }
    
    public static void main(String args[]) {
    
        System.out.println(new CategoryDao().getAllCategories());
    }
}
