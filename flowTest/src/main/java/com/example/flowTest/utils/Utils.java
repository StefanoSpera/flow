package com.example.flowTest.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utils {

	
	
	public static Eta checkEta(GregorianCalendar datanascita)
	{		
	
		GregorianCalendar now=new GregorianCalendar();
	
		int giorno=datanascita.get(Calendar.DAY_OF_MONTH);
		int mese=datanascita.get(Calendar.MONTH);
		int anno=datanascita.get(Calendar.YEAR)+18;
		GregorianCalendar mageta= new GregorianCalendar(anno,mese,giorno,0,0,0);
		mageta.set(Calendar.MILLISECOND, 0);
		long dif=now.getTimeInMillis()-mageta.getTimeInMillis();
	
		return dif > 0?Eta.MAGGIORENNE:Eta.MINORENNE;

	}
}
