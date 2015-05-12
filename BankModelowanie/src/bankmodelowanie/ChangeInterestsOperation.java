package bankmodelowanie;
import java.util.Date;


/**
 *
 * @author adam.kedzia
 */
public class ChangeInterestsOperation extends Operation{
   private InterestState state;
   
   public ChangeInterestsOperation(InterestState newState){
       this.date = new Date();
       this.accepted = null;
       this.state = newState;
   }

    /**
     * @return the state
     */
    public InterestState getState() {
        return state;
    }
}
