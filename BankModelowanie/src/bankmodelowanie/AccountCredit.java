/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.List;


public class AccountCredit implements IAccOption {
    private IAccount acc;
    private ICurrency debit;
    private float fullDebit;
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
                    if(difference > 0 && difference < transfer.getMoney().getAmount())
                    {
                        debit.setAmount(fullDebit);
                        acc.getMoney().setAmount(acc.getMoney().getAmount() + (transfer.getMoney().getAmount() - difference));
                        acc.getHistory().addOperation(operation);
                    }
                    else if(difference >= transfer.getMoney().getAmount())
                    {
                        debit.setAmount(debit.getAmount()+transfer.getMoney().getAmount());
                        acc.getHistory().addOperation(operation);
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
    public List<ICustomer> getCustomer() {
        return acc.getCustomer();
    }

    @Override
    public OperationValidator getValidator() {
        return acc.getValidator();
    }

    @Override
    public void setBank(IBank bank) {
         acc.setBank(bank);
    }

    @Override
    public void setCustomer(List<ICustomer> customer) {
        acc.setCustomer(customer);
    }

    @Override
    public void setMoney(ICurrency money) {
        acc.setMoney(money);
    }

    @Override
    public void setOperationValidator(OperationValidator validator) {
        acc.setOperationValidator(validator);
    }

    @Override
    public void setState(InterestState linearInterest) {
        acc.setState(linearInterest);
    }

    @Override
    public void setAccNumber(Long accNumber) {
        acc.setAccNumber(accNumber);
    }

    @Override
    public void calculateIntrest() {
        acc.calculateIntrest();
    }

    @Override
    public void accept(Visitor visitor) {
        acc.accept(visitor);
     }
    
}
