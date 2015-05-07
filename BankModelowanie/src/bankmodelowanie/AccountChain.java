/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.List;

/**
 *
 * @author Melon
 */
public class AccountChain {
    IAccount acc;
    TransferOperation top;
    AccountChain next;
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
