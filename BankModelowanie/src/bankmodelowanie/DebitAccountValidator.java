/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

/**
 *
 * @author adam.kedzia
 */
public class DebitAccountValidator implements OperationValidator{
    private Float debitLimit;

    
    public DebitAccountValidator(Float limit){
        this.debitLimit = limit;
    }
    
    @Override
    public boolean validateOperation(Operation operation) {
        if(operation.getClass().equals(TransferOperation.class)){
            TransferOperation transfer = (TransferOperation) operation;
            operation.accepted = true;
            return transfer.getSender().getMoney().getAmount() - transfer.getMoney().getAmount() > getDebitLimit();
      
        }
        
        return true;
    }

    /**
     * @return the debitLimit
     */
    public Float getDebitLimit() {
        return debitLimit;
    }
}
