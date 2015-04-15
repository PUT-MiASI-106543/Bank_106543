/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Melon
 */
public class CsvVisitor implements Visitor{

    @Override
    public void TransferOperationVisitor(Operation history) {
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
	     e.printStackTrace();
	} 
    }
}
