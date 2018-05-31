/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Provider;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Rio.Rai
 */
public class ProviderDao {

    /**
     * lay toan bo danh sach nha cung cap
     *
     * @return
     */
    public ArrayList getAllProvider() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from provider");

        ArrayList<Provider> listProducts = (ArrayList<Provider>) query.list();
        transaction.commit();

        return listProducts;
    }

    /**
     * them moi 1 nha cung cap
     * @param provider
     * @return 
     */
    public boolean insertNewProvider(Provider provider) {

        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(provider);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * lay ten nha cung cap theo ma nha cung cap
     * @param providerId
     * @return 
     */
    public ArrayList<Provider> getProviderBy(String providerId) {
    
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from provider where providerId = :providerId");
        query.setString("providerId", providerId);
        
        ArrayList<Provider> provider = (ArrayList<Provider>) query.list();
        transaction.commit();
        
        return provider;
    }
    
    public static void main(String args[]) {

        System.out.println(new ProviderDao().getProviderBy("ss").get(0).getProviderName());
    }
}
