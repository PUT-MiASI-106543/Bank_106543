package bankmodelowanie;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Melon
 */
public class TextVisitor implements Visitor{

    @Override
    public void TransferOperationVisitor(Operation history) {
        String transfers="";
        
        transfers+=history.getReport();
        
        
        try
	{
	    FileWriter writer = new FileWriter("D:\\report.txt", true);
            
            writer.append(transfers);
            writer.append("\r\n");
            
            writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	} 
    }
}
