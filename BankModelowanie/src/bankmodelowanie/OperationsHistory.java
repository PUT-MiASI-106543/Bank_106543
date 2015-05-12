package bankmodelowanie;

import java.util.ArrayList;

/**
 *
 * @author adam.kedzia
 */
public class OperationsHistory {
    private ArrayList<Operation> history;
    
    
    public OperationsHistory(){
        this.history = new ArrayList<>();
    }
    
    void addOperation(Operation operation){
        this.getHistory().add(operation);
    };

    /**
     * @return the history
     */
    public ArrayList<Operation> getHistory() {
        return history;
    }
}
