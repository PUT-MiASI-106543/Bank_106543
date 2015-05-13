package bankmodelowanie;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Melon
 */
public class CsvVisitor implements Visitor{

    @Override
    public void transferOperationVisitor(Operation history) {
        String transfers="";
        transfers+=history.getReport();
        try
	{
	    FileWriter writer = new FileWriter("D:\\report.csv", true);
            writer.append(transfers);
            writer.append("\n");
            writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
            System.out.println(e.getMessage());
	} 
    }
}
