/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;


public class AccountCredit implements IAccOption {
    IAccount acc;
    Currency debit;
    float fullDebit;
    AccountCredit(IAccount acc, Currency debit)
    {
        this.acc = acc;
        this.debit = debit;
        this.fullDebit = debit.getAmount();
    }
    
    @Override
    public void fromDebit(Operation operation) {
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
                    }
                    else if(transfer.getMoney().getAmount() <= acc.getMoney().getAmount())
                    {
                        acc.getMoney().setAmount(acc.getMoney().getAmount() - transfer.getMoney().getAmount());
                    }
                }   
                else if(transfer.getReciver().equals(acc))
                {
                    float difference = fullDebit - debit.getAmount();
                    if(difference > 0)
                    {
                        if(difference > transfer.getMoney().getAmount())
                        {
                            debit.setAmount(fullDebit);
                            acc.getMoney().setAmount(acc.getMoney().getAmount() + (transfer.getMoney().getAmount() - difference));
                        }
                        else
                            debit.setAmount(debit.getAmount()+transfer.getMoney().getAmount());
                    }   
                    else
                    {
                        acc.getMoney().setAmount(acc.getMoney().getAmount() + transfer.getMoney().getAmount());
                    }
                }
        }
    }

    @Override
    public Currency getMoney() {
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
    public Bank getBank() {
        return acc.getBank();
    }

    @Override
    public ArrayList<Customer> getCustomer() {
        return acc.getCustomer();
    }

    @Override
    public OperationValidator getValidator() {
        return acc.getValidator();
    }
    
}