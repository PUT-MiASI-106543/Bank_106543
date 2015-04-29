/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

/**
 *
 * @author Melon
 */
public class AccountChainAmmount extends AccountChain{
    AccountChain next;
    Account acc;
    TransferOperation top;

    public AccountChainAmmount(Account acc, TransferOperation top)
    {
        super(acc, top);
        this.acc = acc;
        this.top = top;
        this.next = new AccountChainNumberOfOperation(acc, top);
    }

    @Override
    public boolean operation(){
        if(top.getMoney().getAmount() > 20000.0f){
            //zgloszenie do US
            return false;
        }
        return next.operation();
    }
    @Override
    public void setNext(AccountChain ac){
        this.next = ac;
    }
}
