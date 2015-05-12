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
    public void addBank(IBank bank);
}
