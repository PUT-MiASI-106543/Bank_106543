/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.Date;

/**
 *
 * @author MeloneQ
 */
public class Investment extends Product{
    
    private ICurrency ammount;
    private int rate;
    private Date endingDate;
    
    public Investment(Date date, Customer customer, ICurrency ammount, int rate, Date endingDate) {
        super(date, customer);
        
        this.ammount = ammount;
        this.rate = rate;
        this.endingDate = endingDate;
    }
    
    public void setAmmount(ICurrency ammount) {
        this.ammount = ammount;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public ICurrency getAmmount() {
        return ammount;
    }

    public int getRate() {
        return rate;
    }

    public Date getEndingDate() {
        return endingDate;
    }
    
}
