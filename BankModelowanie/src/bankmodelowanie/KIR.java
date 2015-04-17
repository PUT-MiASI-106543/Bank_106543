/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author adam.kedzia
 */
public class KIR {
   
   private static KIR instance = null;
   private HashMap<Integer, ArrayList<TransferOperation>> transfersToSend;
   private List<Bank> banks;
   
   protected KIR() {
      banks = new ArrayList<Bank>();
   }
   

   
   public void addBank(Bank bank)
   {
       if(!banks.contains(bank)) banks.add(bank);
   }
   
   public static KIR getInstance() {
      if(instance == null) {
         instance = new KIR();
         instance.transfersToSend = new HashMap<Integer, ArrayList<TransferOperation>>();
      }
      return instance;
   }
   
   public void sheduleTransferOperation(TransferOperation transfer){
       if (Objects.equals(transfer.getReciver().getBank().getId(), transfer.getSender().getBank().getId())) {
           transfer.getReciver().performOperation(transfer, true);
       }else {
          this.putTransferInQueue(transfer);
       }
       
   }
   
   public void sendTransfers(){
       //call KiR api, triggered by sheduler
       for(int id: transfersToSend.keySet())
       {
           for(Bank bank: banks)
           {
               for(TransferOperation top: transfersToSend.get(id))
               {
                   if(bank.getId().equals(top.getReciver().getBank().getId()))
                       bank.transferFromKir(top);
               }
           }
       }
       this.transfersToSend = new HashMap<Integer, ArrayList<TransferOperation>>();
   }
  
   public void receiveTransfers(){
        ArrayList<TransferOperation> receivedArray = new ArrayList<>();
       //Api call to KIR
       for (TransferOperation operation : receivedArray) {
           operation.getReciver().performOperation(operation, true);
       }
   }
   private void putTransferInQueue(TransferOperation operation){
       if (transfersToSend.containsKey(operation.getReciver().getBank().getId())) {
           transfersToSend.get(operation.getReciver().getBank().getId()).add(operation);
       }else {
           ArrayList<TransferOperation> array = new ArrayList<>();
           array.add(operation);
           transfersToSend.put(operation.getReciver().getBank().getId(), array);
       }
   }
}

