/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

/**
 *
 * @author MeloneQ
 */
public interface ICurrency {
    public Float getAmount();
    public void setAmount(Float amount);
    public CurrencyUnit getCurrency();
    public void setCurrency(CurrencyUnit currency);
}
