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
    Account acc;
    TransferOperation top;
    public AccountChain(Account acc, TransferOperation top){
        this.acc = acc;
        this.top = top;
    }
    public boolean operation(){
        return new AccountChainAmmount(acc, top).operation();
    }
}
