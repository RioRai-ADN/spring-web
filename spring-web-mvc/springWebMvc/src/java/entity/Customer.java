/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Rio.Rai
 */

@Entity(name = "customer")
public class Customer {
    
    @Id
    private int customerId;
    
    private String customerName;
    
    private int quantity;
    
    private String productName;
    
    private double prices;

    public Customer() {
    }

    public Customer(int customerId, String customerName, int quantity, String productName, double prices) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.productName = productName;
        this.prices = prices;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    
}
