/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author adam.kedzia
 */
public class KIR {
   
   private static KIR instance = null;
   private HashMap<Integer, ArrayList<TransferOperation>> transfersToSend;
   
   
   protected KIR() {
      // Exists only to defeat instantiation.
   }
   public static KIR getInstance() {
      if(instance == null) {
         instance = new KIR();
         instance.transfersToSend = new HashMap<>();
      }
      return instance;
   }
   
   public void sheduleTransferOperation(TransferOperation transfer){
       if (Objects.equals(transfer.getReciver().getBank().getId(), transfer.getSender().getBank().getId())) {
           transfer.getReciver().performOperation(transfer);
       }else {
          this.putTransferInQueue(transfer);
       }
       
   }
   
   public void sendTransfers(){
       //call KiR api, triggered by sheduler
       this.transfersToSend = new HashMap<>();
   }
  
   public void receiveTransfers(){
        ArrayList<TransferOperation> receivedArray = new ArrayList<>();
       //Api call to KIR
       for (TransferOperation operation : receivedArray) {
           operation.getReciver().performOperation(operation);
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

