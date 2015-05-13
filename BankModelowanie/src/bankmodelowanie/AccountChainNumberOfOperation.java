package bankmodelowanie;


/**
 *
 * @author Melon
 */
public class AccountChainNumberOfOperation extends AccountChain{
    private final IAccount acc;
    private final TransferOperation top;
    private AccountChain next;
    public AccountChainNumberOfOperation(IAccount acc, TransferOperation top) {
        super(acc, top);
        this.acc = acc;
        this.top = top;
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
    
    public void runNext(){
        this.next.operation();
    }
}
