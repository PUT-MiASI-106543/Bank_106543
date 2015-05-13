package bankmodelowanie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author adam.kedzia
 */
public class KIR implements IKIR {
   
   private static KIR instance = null;
   private Map<Integer, List<TransferOperation>> transfersToSend;
   private List<IBank> banks;
   
   protected KIR() {
      banks = new ArrayList<>();
   }
   

   
   @Override
   public void addBank(IBank bank)
   {
       if(!banks.contains(bank)) 
           banks.add(bank);
   }
   
   public static KIR getInstance() {
      if(instance == null) {
         instance = new KIR();
         instance.transfersToSend = new HashMap<>();
      }
      return instance;
   }
   
   @Override
   public void sheduleTransferOperation(TransferOperation transfer){
       if (Objects.equals(transfer.getReciver().getBank().getId(), transfer.getSender().getBank().getId())) {
           transfer.getReciver().performOperation(transfer, true);
       }else {
          this.putTransferInQueue(transfer);
       }
       
   }
   
   @Override
   public void sendTransfers(){
       for(int id: transfersToSend.keySet())
       {
           for(IBank bank: banks)
           {
               for(TransferOperation top: transfersToSend.get(id))
               {
                   if(bank.getId().equals(top.getReciver().getBank().getId()))
                       bank.transferFromKir(top);
               }
           }
       }
       this.transfersToSend = new HashMap<>();
   }
  
   @Override
   public void receiveTransfers(){
        List<TransferOperation> receivedArray = new ArrayList<>();
       for (TransferOperation operation : receivedArray) {
           operation.getReciver().performOperation(operation, true);
       }
   }
   @Override
   public void putTransferInQueue(TransferOperation operation){
       if (transfersToSend.containsKey(operation.getReciver().getBank().getId())) {
           transfersToSend.get(operation.getReciver().getBank().getId()).add(operation);
       }else {
           List<TransferOperation> array = new ArrayList<>();
           array.add(operation);
           transfersToSend.put(operation.getReciver().getBank().getId(), array);
       }
   }
}

