/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.Date;

/**
 *
 * @author adam.pacanowski
 */
public abstract class Product {
    protected int id;
    protected Date date;
    protected Customer customer;
    
    public Product(Customer customer){
        this.id = this.hashCode();
        this.date = new Date();
        this.customer = customer;
    }
    
    public Product(Date date, Customer customer){
        this.id = this.hashCode();
        this.date = date;
        this.customer = customer;
    }
}
