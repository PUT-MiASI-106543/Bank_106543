package bankmodelowanie;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */
public class Account implements IAccount{
    private Long accountNumber;
    private ICurrency money;
    private Float interest;
    private OperationValidator validator;
    final private OperationsHistory history;
    private IBank bank;
    private ArrayList<ICustomer> customers;
    private InterestState state;

   
   
    @Override
    public void performOperation(Operation operation, boolean exist){
        if (this.getValidator().validateOperation(operation) || exist) {
            if (operation.getClass().equals(TransferOperation.class)) {
                TransferOperation transfer = (TransferOperation) operation;
                history.addOperation(operation);
                if (this.equals(transfer.getSender())) {
                    getMoney().setAmount(getMoney().getAmount() - transfer.getMoney().getAmount());
                    // Send to KIR
                }else{
                    getMoney().setAmount(getMoney().getAmount() + transfer.getMoney().getAmount());
                }
                if(!exist) bank.getKir().sheduleTransferOperation(transfer);
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
    
    @Inject
    public Account(IBank b){
        this.bank = b;
        this.history = new OperationsHistory();
    }
    
    @Override
    public void calculateIntrest(){
        final ICurrency interest = state.calculateInterest(this);
        if (interest != null){
            if (this.money.getCurrency() == CurrencyUnit.PLN){
                float value = this.money.getAmount();
                //this.money = new Currency(value + interest.getAmount(), CurrencyUnit.PLN);
                this.money = BankModelowanie.dInjector.InjectCurrency(value + interest.getAmount(), CurrencyUnit.PLN);
            }
        }
    }
    
    @Override
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
    @Override
    public ICurrency getMoney() {
        return money;
    }

    /**
     * @return the interest
     */
    @Override
    public Float getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    @Override
    public void setInterest(Float interest) {
        this.interest = interest;
    }

    /**
     * @return the history
     */
    @Override
    public OperationsHistory getHistory() {
        return history;
    }

    /**
     * @return the accountNumber
     */
    @Override
    public Long getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the bank
     */
    @Override
    public IBank getBank() {
        return bank;
    }

    /**
     * @return the customer
     */
    @Override
    public ArrayList<ICustomer> getCustomer() {
        return customers;
    }

    /**
     * @return the validator
     */
    @Override
    public OperationValidator getValidator() {
        return validator;
    }

    @Override
    public void setBank(IBank bank) {
        this.bank = bank;
    }

    @Override
    public void setCustomer(ArrayList<ICustomer> customer) {
        this.customers = customer;
    }

    @Override
    public void setMoney(ICurrency money) {
        this.money = money;
    }

    @Override
    public void setOperationValidator(OperationValidator validator) {
        this.validator = validator;
    }

    @Override
    public void setState(InterestState linearInterest) {
        this.state = linearInterest;
    }

    @Override
    public void setAccNumber(Long accNumber) {
        this.accountNumber = accNumber;
    }
    
}

