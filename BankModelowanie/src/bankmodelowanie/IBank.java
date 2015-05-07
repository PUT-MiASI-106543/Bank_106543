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
public interface IBank {
    public KIR kir = null;
    public void transferFromKir(TransferOperation top);
    public ICustomer getCustomerByPESEL(String PESEL);
    public void addCustomer(ICustomer customer);
    public void removeCustomer(ICustomer customer);
    public void addProduct(Product product);
    public void removeProduct(Product product);
    public ICurrency conversion(ICurrency currency, CurrencyUnit currencyUnit, float rate, float spread);
    public Integer getId();
    public void setKir(KIR kir);
    public IKir getKir();
    public void setId(int id);
}
