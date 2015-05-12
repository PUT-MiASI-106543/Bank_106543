package bankmodelowanie;

import java.util.List;

/**
 *
 * @author MeloneQ
 */
public interface ICustomer {
    public boolean doOperation(Operation operation, boolean exist);
    public boolean equals(Object ob);
    public int hashCode();
    public void addAccount(IAccount acc);
    public void removeAccount(IAccount acc);
    public String getName();
    public void setName(String name);
    public String getSurname();
    public void setSurname(String surname);
    public String getPESEL();
    public void setPESEL(String PESEL);
    public List<IAccount> getAccounts();
}
