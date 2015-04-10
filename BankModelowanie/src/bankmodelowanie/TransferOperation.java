/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.Date;

/**
 *
 * @author adam.kedzia
 */
public class TransferOperation extends Operation{
    private Currency money;
    private Account sender;
    private Account receiver;

    
    
    
   public TransferOperation(Currency money, Account sender, Account receiver){
       this.date = new Date();
       this.accepted = null;
       this.money = money;
       this.sender = sender;
       this.receiver = receiver;
   }
    /**
     * @return the money
     */
    public Currency getMoney() {
        return money;
    }

    /**
     * @return the sender
     */
    public Account getSender() {
        return sender;
    }

    /**
     * @return the receiver
     */
    public Account getReciver() {
        return receiver;
    }
}
