package bankmodelowanie;

import java.util.HashMap;

/**
 *
 * @author Melon
 */
public class AccountChainNumberOfOperation extends AccountChain{
    private final IAccount acc;
    private final TransferOperation top;
    private final HashMap<Account, Integer> transfers;
    private AccountChain next;
    public AccountChainNumberOfOperation(IAccount acc, TransferOperation top) {
        super(acc, top);
        this.acc = acc;
        this.top = top;
        transfers = new HashMap<>();
    }
    
    @Override
    public boolean operation(){
        int counter = 0;
        for(Operation op: acc.getHistory().getHistory())
        {
            if (op.getClass().equals(TransferOperation.class)) {
                TransferOperation transfer = (TransferOperation) op;
                if(top.getReciver().equals(transfer.getReciver())){
                    counter++;
                }
           }
        }
        
        return counter <= 3;
    }
    @Override
    public void setNext(AccountChain ac)
    {
        this.next = ac;
    }
}
