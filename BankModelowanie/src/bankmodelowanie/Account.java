/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */
public class Account implements IAccount{
    private Long accountNumber;
    private Currency money;
    private Float interest;
    private OperationValidator validator;
    private OperationsHistory history;
    private Bank bank;
    private ArrayList<Customer> customers;
    private InterestState state;

   
   
    public void performOperation(Operation operation){
        if (this.getValidator().validateOperation(operation)) {
            if (operation.getClass().equals(TransferOperation.class)) {
                TransferOperation transfer = (TransferOperation) operation;
                history.addOperation(operation);
                if (this.equals(transfer.getSender())) {
                    getMoney().setAmount(getMoney().getAmount() - transfer.getMoney().getAmount());
                    // Send to KIR
                }else{
                    getMoney().setAmount(getMoney().getAmount() + transfer.getMoney().getAmount());
                }
            }
        }
    }
    
    void evaluateInterest(){
        getMoney().setAmount(getMoney().getAmount() + getMoney().getAmount() * getInterest());
    }
    
    @Override
    public boolean equals(Object ob){
        if(!(ob instanceof Account)) return false;
        return Objects.equals(accountNumber, ((Account)ob).accountNumber);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.accountNumber);
        return hash;
    }
    
    public Account(Bank bank, ArrayList<Customer> customer, Long accNumber, Currency money, OperationValidator validator){
        this.bank = bank;
        this.customers = customer;
        this.accountNumber = accNumber;
        this.money = money;
        this.validator = validator;
        this.history = new OperationsHistory();
        this.interest = 0.f;
        this.state = new LinearInterest(5.00f);
    }
    
    public Account(Bank bank, ArrayList<Customer> customer, Long accNumber, Currency money, OperationValidator validator, InterestState state){
        this.bank = bank;
        this.customers = customer;
        this.accountNumber = accNumber;
        this.money = money;
        this.validator = validator;
        this.history = new OperationsHistory();
        this.interest = 0.f;
        this.state = state;
    }

    public Account(Bank bank, ArrayList<Customer> customer, Long accNumber, Currency money, OperationValidator validator, Float interest){
        this(bank, customer, accNumber, money, validator);
        this.interest = interest;
    }
    
    public void calculateIntrest(){
        Currency interest = state.calculateInterest(this);
        if (interest != null){
            if (this.money.getCurrency() == CurrencyUnit.PLN){
                float value = this.money.getAmount();
                this.money = new Currency(value + interest.getAmount(), CurrencyUnit.PLN);
            }
        }
    }
    
    public void Accept(Visitor visitor)
    {
        for(Operation op : history.getHistory())
        {
            op.Accept(visitor);
        }
    }
    /**
     * @return the money
     */
    public Currency getMoney() {
        return money;
    }

    /**
     * @return the interest
     */
    public Float getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(Float interest) {
        this.interest = interest;
    }

    /**
     * @return the history
     */
    public OperationsHistory getHistory() {
        return history;
    }

    /**
     * @return the accountNumber
     */
    public Long getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * @return the customer
     */
    public ArrayList<Customer> getCustomer() {
        return customers;
    }

    /**
     * @return the validator
     */
    public OperationValidator getValidator() {
        return validator;
    }
    
}

