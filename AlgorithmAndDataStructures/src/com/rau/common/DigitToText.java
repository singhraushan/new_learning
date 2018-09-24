/**
 * 
 */
package com.rau.common;

/**
 * @author Raushan kumar
 *
 */
public class DigitToText {

	public static void main(String[] args) {
		System.out.println(digitToText(200010));
	}

    public static String simpleConvertDigitToText(String str) {
    	int n= Integer.parseInt(str);
    	int length = str.length();
    	int count = 0;
		String result = "";
		while(n>0) {
			int lastDigit = n%10;
			if(result.equals(""))//1st time
			   result = text(lastDigit);
			else
				result = text(lastDigit)+" "+result;
			n=n/10;
			count++;
		}
		if(count==length)
		  return result;
		else{
			for(int i=0;i<length-count;){
				result = text(0)+" "+result;
				i++;
			}
			return result;
		}
			
	}
    private static String text(int n) {
		String result = "";
		switch(n) {
		case 0: result = "ZERO ";
		        break;
		case 1: result =  "ONE";
		        break;
		case 2: result = "TWO";
                break;
		case 3: result =  "THREE";
		        break;
		case 4: result = "FOUR";
		        break;
		case 5: result =  "FIVE";
		        break;
		case 6: result = "SIX";
		        break;
		case 7: result =  "SEVEN";
		        break;
		case 8: result = "EIGHT";
                break;
        case 9: result =  "NINE";
                break;
		}
		return result;
	}
    
    private static String getText(int n) {
		String result = "";
		switch(n) {
		/*case 0: result = "ZERO ";
		        break;*/
		case 1: result =  "ONE ";
		        break;
		case 2: result = "TWO ";
                break;
		case 3: result =  "THREE ";
		        break;
		case 4: result = "FOUR ";
		        break;
		case 5: result =  "FIVE ";
		        break;
		case 6: result = "SIX ";
		        break;
		case 7: result =  "SEVEN ";
		        break;
		case 8: result = "EIGHT ";
                break;
        case 9: result =  "NINE ";
                break;
		case 10: result = "TEN ";
		        break;
		case 11: result =  "ELEVEN ";
		        break;
		case 12: result = "TWELVE ";
                break;
		case 13: result =  "THIRTEEN ";
		        break;
		case 14: result = "FOURTEEN ";
		        break;
		case 15: result =  "FIFTEEN ";
		        break;
		case 16: result = "SIXTEEN ";
		        break;
		case 17: result =  "SEVENTEEN ";
		        break;
		case 18: result = "EIGHTEEN ";
                break;
        case 19: result =  "NINETEEN ";
                break;
		case 20: result =  "TWENTY ";
		        break;
		case 30: result =  "THIRTY ";
		        break;
		case 40: result = "FORTY ";
		        break;
		case 50: result =  "FIFTY ";
		        break;
		case 60: result = "SIXTY ";
		        break;
		case 70: result = "SEVENTY ";
		        break;
		case 80: result = "EIGHTY ";
		        break;
		case 90: result = "NINETY ";
		        break;
		case 100: result = "HUNDRED ";
		        break;
		case 1000: result = "THOUSAND ";
		        break;
		case 100000: result = "LAKH ";
		        break;
		case 10000000: result = "CRORE ";
		        break;
		}
		return result;
	}
    
    public static String digitToText(long number) {
    	String result ="";
    	long crore=10000000,lakh=100000,thousand=1000,hundred=100;
    	long temp=0;
    	int twenty=20,ten=10;
    	if(number==0)
    		return "ZERO";
    	if(number>=crore){//crore
    		temp = number/crore;
    		if(temp<=twenty)
    			result +=getText((int)temp);
    		else{
    			result +=getText((int)(temp/ten)*ten);
    			result +=getText((int)temp%ten);
    		}
    		result +=getText((int)crore);
    		number= number%crore;
    	}
    	
    	if(number>=lakh){//lakh
    		temp = number/lakh;
    		if(temp<=twenty)
    			result +=getText((int)temp);
    		else{
    			result +=getText((int)(temp/ten)*ten);
    			result +=getText((int)temp%ten);
    		}
    		result +=getText((int)lakh);
    		number= number%lakh;
    	}
    	
    	if(number>=thousand){//thousand
    		temp = number/thousand;
    		if(temp<=twenty)
    			result +=getText((int)temp);
    		else{
    			result +=getText((int)(temp/ten)*ten);
    			result +=getText((int)temp%ten);
    		}
    		result +=getText((int)thousand);
    		number= number%thousand;
    	}
    	
    	if(number>=hundred){//hundred
    		temp = number/hundred;
    		result +=getText((int)temp);
    		result +=getText((int)hundred);
    		number= number%hundred;
    	}
    	
    	if(temp<=twenty)
    		result +=getText((int)number);
		else{
			result +=getText((int)(number/ten)*ten);
			result +=getText((int)number%ten);
		}
    	
		return result;	
	}
    
}
