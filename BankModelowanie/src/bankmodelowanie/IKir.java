/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

/**
 *
 * @author MeloneQ
 */
public interface IKir {
    public void putTransferInQueue(TransferOperation operation);
    public void receiveTransfers();
    public void sendTransfers();
    public void sheduleTransferOperation(TransferOperation transfer);
}
