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
