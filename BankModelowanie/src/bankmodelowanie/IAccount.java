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
public interface IAccount {
        public Currency getMoney();
        public Float getInterest();
        public void setInterest(Float interest);
        public OperationsHistory getHistory();
        public Long getAccountNumber();
        public Bank getBank();
        public ArrayList<Customer> getCustomer();
        public OperationValidator getValidator();
}
