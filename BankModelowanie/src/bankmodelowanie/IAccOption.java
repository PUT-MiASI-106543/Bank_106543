/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;

/**
 *
 * @author MeloneQ
 */
public interface IAccOption extends IAccount{

    public void fromDebit(Operation operation);
    @Override
    public Currency getMoney();
    @Override
    public Float getInterest();
    @Override
    public void setInterest(Float interest);
    @Override
    public OperationsHistory getHistory();
    @Override
    public Long getAccountNumber();
    @Override
    public Bank getBank();
    @Override
    public ArrayList<Customer> getCustomer();
    @Override
    public OperationValidator getValidator();
    
}
