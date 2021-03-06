package bankmodelowanie;
import java.util.Date;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */
public abstract class Operation {
    protected int id;
    protected Date date;
    protected Boolean accepted;

    /**
     * visitator element
     * @param visitor 
     */
    public void accept(Visitor visitor){ 
    }
    
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * @return the report
     */
    public String getReport(){
        return "";
    }
    
    /**
     * @return the accepted
     */
    public Boolean getAccepted() {
        return accepted;
    }

    /**
     * @param accepted the accepted to set
     */
    public void setAccepted(Boolean accepted) {
        if (this.accepted == null) {
             this.accepted = accepted;
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
        
}
