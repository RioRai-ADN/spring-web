/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Rio.Rai
 */
public class ProductDao {

    /**
     * lay toan bo danh sach san pham
     *
     * @return
     */
    public ArrayList getAllProduct() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from product");

        ArrayList<Product> listProduct = (ArrayList<Product>) query.list();
        transaction.commit();

        return listProduct;
    }

    /**
     * them mot san pham moi
     * @param product
     * @return 
     */
    public boolean insertProduct(Product product) {

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    /**
     * tim san pham voi productID
     * @param productId
     * @return 
     */
    public ArrayList<Product> getProductBy(String productId) {
    
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from product where productId = :productId");
        query.setString("productId", productId);
        
        ArrayList<Product> product = (ArrayList<Product>) query.list();
        transaction.commit();
        
        return product;
    }
    
    /**
     * lay danh sach san pham theo nha cung cap
     * @param providerId
     * @return 
     */
    public ArrayList<Product> getProductListBy(String providerId) {
    
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from product where providerId = :providerId");
        query.setString("providerId", providerId);
        
        ArrayList<Product> productList = (ArrayList<Product>) query.list();
        transaction.commit();
        
        return productList;
    }
    
    /**
     * cap nhat san pham
     * @param product
     * @return 
     */
    public boolean updateProduct(Product product) {
    
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            
            return true;
        } catch (Exception e) {
        }
        
        return false;
    }
    public static void main(String args[]) {

        System.out.println(new ProductDao().getProductBy("IPW").get(0).getProductName());
    }
}
