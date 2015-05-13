/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;
import java.util.List;
/**
 *
 * @author MeloneQ
 */
public interface IAccount {
        public ICurrency getMoney();
        public Float getInterest();
        public void setInterest(Float interest);
        public OperationsHistory getHistory();
        public Long getAccountNumber();
        public IBank getBank();
        public List<ICustomer> getCustomer();
        public OperationValidator getValidator();
        public void performOperation(Operation operation, boolean exist);
        public void calculateIntrest();
        public void accept(Visitor visitor);
        public void setBank(IBank bank);
        public void setCustomer(List<ICustomer> customer);
        public void setMoney(ICurrency money);
        public void setOperationValidator(OperationValidator validator);
        public void setState(InterestState linearInterest);
        public void setAccNumber(Long accNumber);
}
