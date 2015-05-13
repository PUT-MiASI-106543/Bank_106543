package bankmodelowanie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author adam.pacanowski
 */
public class Customer implements ICustomer{
    private String name;
    private String surname;
    private String pesel;
    private List<IAccount> accounts;
    
    public Customer(){
        accounts = new ArrayList<>();
    }
    
    public Customer(String name, String surname, String pesel){
    	this.name = name;
    	this.surname = surname;
        this.pesel = pesel;
        accounts = new ArrayList<>();
    }
    
    @Override
    public boolean doOperation(Operation operation, boolean exist){
        if(getAccounts().contains(((TransferOperation)operation).getReciver())){
            IAccount acc = ((TransferOperation)operation).getReciver();
            acc.performOperation(operation, exist);
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean equals(Object ob){
        if(!(ob instanceof Customer)) 
            return false;
        return pesel.equals(((Customer)ob).pesel);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.pesel);
        return hash;
    }
    
    @Override
    public void addAccount(IAccount acc){
        getAccounts().add(acc);
    }
    
    @Override
    public void removeAccount(IAccount acc){
        getAccounts().remove(acc);
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    @Override
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the PESEL
     */
    @Override
    public String getPESEL() {
        return pesel;
    }

    /**
     * @param PESEL the PESEL to set
     */
    @Override
    public void setPESEL(String pesel) {
        this.pesel = pesel;
    }

    /**
     * @return the accounts
     */
    @Override
    public List<IAccount> getAccounts() {
        return accounts;
    }
}
