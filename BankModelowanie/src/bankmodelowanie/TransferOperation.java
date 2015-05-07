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
    private ICurrency money;
    private IAccount sender;
    private IAccount receiver;

    
    
    
   public TransferOperation(ICurrency money, IAccount sender, IAccount receiver){
       this.date = new Date();
       this.accepted = null;
       this.money = money;
       this.sender = sender;
       this.receiver = receiver;
   }
    /**
     * @return the money
     */
    public ICurrency getMoney() {
        return money;
    }

    /**
     * @return the sender
     */
    public IAccount getSender() {
        return sender;
    }

    /**
     * @return the receiver
     */
    public IAccount getReciver() {
        return receiver;
    }
    
    public void Accept(Visitor visitor)
    {
        visitor.TransferOperationVisitor(this);
    }
    
    public String getReport()
    {
        return money.getAmount().toString()+", "+sender.getAccountNumber().toString()+", "+receiver.getAccountNumber().toString();
    }
}
