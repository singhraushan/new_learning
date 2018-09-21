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
		System.out.println(convertDigitToText("001"));
	}

    public static String convertDigitToText(String str) {
    	int n= Integer.parseInt(str);
    	int length = str.length();
    	int count = 0;
		String result = "";
		while(n>0) {
			int lastDigit = n%10;
			if(result.equals(""))//1st time
			   result = getText(lastDigit);
			else
				result = getText(lastDigit)+" "+result;
			n=n/10;
			count++;
		}
		if(count==length)
		  return result;
		else{
			for(int i=0;i<length-count;){
				result = getText(0)+" "+result;
				i++;
			}
			return result;
		}
			
	}
    
    private static String getText(int n) {
		String result = "";
		switch(n) {
		case 0: result = "ZERO";
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
		}
		return result;
	}
}
