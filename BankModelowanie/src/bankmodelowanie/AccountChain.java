package bankmodelowanie;

/**
 *
 * @author Melon
 */
public class AccountChain {
    protected final IAccount acc;
    protected final TransferOperation top;
    private AccountChain next;
    public AccountChain(IAccount acc, TransferOperation top){
        this.acc = acc;
        this.top = top;
        this.next = new AccountChainAmmount(acc, top);
    }
    public boolean operation(){
        return new AccountChainAmmount(acc, top).operation();
    }
    public void setNext(AccountChain ac){
        this.next = ac;
    }
}
