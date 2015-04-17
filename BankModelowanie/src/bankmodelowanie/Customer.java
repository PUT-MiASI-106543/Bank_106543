/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author adam.pacanowski
 */
public class Customer {
    private String name;
    private String surname;
    private String PESEL;
    private List<Account> accounts;
    
    public Customer(String name, String surname, String PESEL){
    	this.name = name;
    	this.surname = surname;
        this.PESEL = PESEL;
        accounts = new ArrayList<>();
    }
    
    public boolean doOperation(Operation operation, boolean exist){
        if(getAccounts().contains(((TransferOperation)operation).getReciver())){
            Account acc = ((TransferOperation)operation).getReciver();
            acc.performOperation(operation, exist);
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean equals(Object ob){
        if(!(ob instanceof Customer)) return false;
        return PESEL.equals(((Customer)ob).PESEL);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.PESEL);
        return hash;
    }
    
    public void addAccount(Account acc){
        getAccounts().add(acc);
    }
    
    public void removeAccount(Account acc){
        getAccounts().remove(acc);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the PESEL
     */
    public String getPESEL() {
        return PESEL;
    }

    /**
     * @param PESEL the PESEL to set
     */
    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    /**
     * @return the accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }
    
    
}
