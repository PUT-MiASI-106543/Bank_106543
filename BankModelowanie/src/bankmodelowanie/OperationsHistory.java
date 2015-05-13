package bankmodelowanie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adam.kedzia
 */
public class OperationsHistory {
    private List<Operation> history;
    
    
    public OperationsHistory(){
        this.history = new ArrayList<>();
    }
    
    void addOperation(Operation operation){
        this.getHistory().add(operation);
    }

    /**
     * @return the history
     */
    public List<Operation> getHistory() {
        return history;
    }
}
