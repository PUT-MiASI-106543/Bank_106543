/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */


public class Currency {
    private Float amount;
    private CurrencyUnit currency;

    public Currency(Float amount, CurrencyUnit currency){
        this.amount = amount;
        this.currency = currency;
    }
    
    /**
     * @return the amount
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @return the currency
     */
    public CurrencyUnit getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(CurrencyUnit currency) {
        this.currency = currency;
    }

    

}
