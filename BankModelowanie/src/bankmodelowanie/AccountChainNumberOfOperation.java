/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.HashMap;

/**
 *
 * @author Melon
 */
public class AccountChainNumberOfOperation extends AccountChain{
    IAccount acc;
    TransferOperation top;
    HashMap<Account, Integer> transfers;
    AccountChain next;
    public AccountChainNumberOfOperation(IAccount acc, TransferOperation top) {
        super(acc, top);
        this.acc = acc;
        this.top = top;
        transfers = new HashMap<Account, Integer>();
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
        
        if(counter > 3)
            return false;
        return true;
    }
    @Override
    public void setNext(AccountChain ac)
    {
        this.next = ac;
    }
}
