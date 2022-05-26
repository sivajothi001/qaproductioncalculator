package testUtilities;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;


public class UnitPriceCalculation {
	
	static Object[][] array = XLUtility.getDataFromloginSheet("Input_Data.xlsx","SellingPrices");
	
	public static String getUintPrice(String QReq) {
		
		Object[][] linearpricing = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditCilents");
		
		DecimalFormat df = new DecimalFormat("####0.000");
		
		String UnitPrice = null;
		
		String linearpricing1 =  linearpricing[0][4].toString();
		
		if(linearpricing1.contains("Yes")) {
			
			double pMax =  Double.parseDouble(getqMax()) *  Double.parseDouble(getmaximumPrice());

			double pMin =  Double.parseDouble(getQmin()) *  Double.parseDouble(getminimumPrice());
			
			double pInt = (pMax - pMin) / (Double.parseDouble(getqMax()) - Double.parseDouble(getQmin()));
			
			double RequestedQuote = Double.parseDouble(getminimumPrice()) * Double.parseDouble(getQmin()) +(pInt*( Double.parseDouble(QReq)-Double.parseDouble(getQmin())));
			
			double UnitPrice1 = RequestedQuote/Double.parseDouble(QReq);
			
			UnitPrice =df.format(UnitPrice1);
			
		}else {
			int qu = 0;
			Integer[] column = new Integer[array.length];
		    for(int i=0; i<column.length; i++){
		       String str= (String)array[i][0];
		       column[i]  = Integer.parseInt(str);
		       
		    }
		    
		    if(Arrays.stream(column).anyMatch(i -> i == Integer.parseInt(QReq))) {
		    	
		    	qu = Integer.parseInt(QReq);
		    	
		    }else {
		    	
		    	qu =IntStream.range(0, array.length)
		                .map(i -> column[column.length - 1 - i])
		                .filter(n -> n < Integer.parseInt(QReq))
		                .findFirst().orElse(-1);
		    	
		    }
		    String UnitPrice1 = null;
		    
		    for(int i=1;i<=array.length;i++) {
		    	
		    	if ( array[i-1][0].toString().equals(Integer.toString(qu))) {
		    		
		    		UnitPrice1 = array[i-1][1].toString();
		    		
		    		break;
		    	}
		    }
		    UnitPrice = df.format(Double.parseDouble(UnitPrice1));
		}
		
		return UnitPrice;
	}
	
	
	public static String getQmin() {
		
		Integer[] column = new Integer[array.length];
	    for(int i=0; i<column.length; i++){
	       String str= (String)array[i][0];
	       column[i]  = Integer.parseInt(str);
	    }
	    
	    int qMin = Collections.min(Arrays.asList(column));	    
	    
	    String sqMin = Integer.toString(qMin);
	    
	    return sqMin;
	    
	}
	
	public static String getqMax() {
		
		Integer[] column = new Integer[array.length];
	    for(int i=0; i<column.length; i++){
	       String str= (String)array[i][0];
	       column[i]  = Integer.parseInt(str);
	    }
		
	    int qMax = Collections.max(Arrays.asList(column));
	    
	    String sqMax = Integer.toString(qMax);
	    
	    return sqMax;
	}
	    
	
	public static String getminimumPrice() {
		
		String minimumPrice = null;
		
	    for(int i=1;i<=array.length;i++) {
	    	
	    	if ( array[i-1][0].toString().equals(getQmin())) {
	    		
	    		minimumPrice = array[i-1][1].toString();
	    		
	    		break;
	    	}
	    }
	    
	    return minimumPrice;
	}
	
	public static String getmaximumPrice() {
		
		String maximumPrice = null;
		
	    for(int i=1;i<=array.length;i++) {
	    	
	    	if ( array[i-1][0].toString().equals(getqMax())) {
	    		
	    		maximumPrice = array[i-1][1].toString();
	    		
	    		break;
	    	}
	    }
	    
	    return maximumPrice;
	}
	    
	}


