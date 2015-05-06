/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;


public class AccountCredit implements IAccOption {
    IAccount acc;
    ICurrency debit;
    float fullDebit;
    AccountCredit(IAccount acc, ICurrency debit)
    {
        this.acc = acc;
        this.debit = debit;
        this.fullDebit = debit.getAmount();
    }
    
    public ICurrency getDebit(){
        return debit;
    }
            
    
    @Override
    public void performOperation(Operation operation, boolean exist) {
        if(operation.getClass().equals(TransferOperation.class)){
                TransferOperation transfer = (TransferOperation) operation;
                if(this.equals(transfer.getSender()))
                {
                    // Send to KIR
                }
                if(transfer.getSender().equals(acc))
                {
                    if(transfer.getMoney().getAmount() > acc.getMoney().getAmount()
                            && transfer.getMoney().getAmount() <= acc.getMoney().getAmount() + debit.getAmount())
                    {
                        debit.setAmount(debit.getAmount() - (transfer.getMoney().getAmount() - acc.getMoney().getAmount()));
                        acc.getMoney().setAmount(0.0f);
                        acc.getHistory().addOperation(operation);
                    }
                    else if(transfer.getMoney().getAmount() <= acc.getMoney().getAmount())
                    {
                        acc.getMoney().setAmount(acc.getMoney().getAmount() - transfer.getMoney().getAmount());
                        acc.getHistory().addOperation(operation);
                    }
                }   
                else if(transfer.getReciver().equals(acc))
                {
                    float difference = fullDebit - debit.getAmount();
                    if(difference > 0)
                    {
                        if(difference < transfer.getMoney().getAmount())
                        {
                            debit.setAmount(fullDebit);
                            acc.getMoney().setAmount(acc.getMoney().getAmount() + (transfer.getMoney().getAmount() - difference));
                            acc.getHistory().addOperation(operation);
                        }
                        else
                        {
                            debit.setAmount(debit.getAmount()+transfer.getMoney().getAmount());
                            acc.getHistory().addOperation(operation);
                        }
                            
                    }   
                    else
                    {
                        acc.getMoney().setAmount(acc.getMoney().getAmount() + transfer.getMoney().getAmount());
                        acc.getHistory().addOperation(operation);
                    }
                }
        }
    }

    @Override
    public ICurrency getMoney() {
        return acc.getMoney();
    }

    @Override
    public Float getInterest() {
        return acc.getInterest();
    }

    @Override
    public void setInterest(Float interest) {
        acc.setInterest(interest);
    }

    @Override
    public OperationsHistory getHistory() {
        return acc.getHistory();
    }

    @Override
    public Long getAccountNumber() {
         return acc.getAccountNumber();
    }

    @Override
    public IBank getBank() {
        return acc.getBank();
    }

    @Override
    public ArrayList<ICustomer> getCustomer() {
        return acc.getCustomer();
    }

    @Override
    public OperationValidator getValidator() {
        return acc.getValidator();
    }

    @Override
    public void setBank(IBank bank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCustomer(ArrayList<ICustomer> customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMoney(ICurrency money) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOperationValidator(OperationValidator validator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(InterestState linearInterest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
