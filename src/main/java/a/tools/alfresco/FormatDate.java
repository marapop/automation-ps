package a.tools.alfresco;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatDate {

	
	private String changeDate(String strDate, String dateFormat){
   
	    try
	    {
	      SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yy");
	     
	      Date date = sdfSource.parse(strDate);
	     
	      SimpleDateFormat sdfDestination = new SimpleDateFormat(dateFormat);
	     
	      strDate = sdfDestination.format(date);
	     
	      System.out.println("Date is converted from dd/MM/yy format to " + dateFormat);
	      System.out.println("Converted date is : " + strDate);
	     
	    }
	    catch(ParseException pe)
	    {
	      System.out.println("Parse Exception : " + pe);
	    }
		
		return strDate;
	}
	
	
	
	public String changeDateBulkConfirmFormat(String date){
		return changeDate(date, "EEEEEEEEE, MMMMMMMM dd, yyyy");
	}
	
	public String changeDateFieldsFormat(String date){
		return changeDate(date, "EEE dd MMM yyyy");
	}
}
