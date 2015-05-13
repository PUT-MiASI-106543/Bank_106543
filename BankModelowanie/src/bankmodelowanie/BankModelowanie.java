package bankmodelowanie;

/**
 *
 * @author adam.kedzia
 */
public class BankModelowanie {

    private static DInjector dInjector;
    
    private BankModelowanie(){
        
    }
    
    public static DInjector getInjector(){
        return dInjector;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       dInjector = new DInjector();
    }
     
}
