/**
 * 
 */
package com.rau.common;

/**
 * @author Raushan kumar
 *
 */
public class DateCalendar {

	public static void main(String[] args) {
		System.out.println(getWeekDay(2018,9,23));
	}
    public static String getWeekDay(int yyyy,int mm,int dd) {
    	if(!isValidDate(yyyy, mm, dd))
    		return "";
	 	String result="";
	 	
	 	int noOfLeapYrs = (yyyy-1)/4-(yyyy-1)/100+(yyyy-1)/400;//ignoring current year because it's not completed
	 	
	 	long noOfDays = (yyyy-1)*365 +  noOfLeapYrs;//total number of days up to last yr(considering all yr non-leap yr) then aading number of leap yrs till last yr.
	    
	 	//now add number of days
	 	switch (mm) {//without break in case.
		case 12: noOfDays +=30;//total no. of days in last month i.e. Nov in this case. 
		case 11: noOfDays +=31;
		case 10: noOfDays +=30;
		case 9: noOfDays +=31; 
		case 8: noOfDays +=31;
		case 7: noOfDays +=30;
		case 6: noOfDays +=31; 
		case 5: noOfDays +=30;
		case 4: noOfDays +=31;
		case 3: noOfDays = noOfDays+28+(isLeapYear(yyyy)?1:0); 
		case 2: noOfDays +=31;
		case 1: noOfDays +=dd ;
		}
	 	
	 	//find week day.
	 	switch ((int)noOfDays%7) {//with break in case.
        case 0: result = "SUNDAY";// 0 means sunday
                break;
		case 6: result = "SATURDAY"; 
        		break;
		case 5: result = "FRIDAY";
        		break;		
		case 4: result = "THURSDAY";
        		break;
		case 3: result = "WEDNESDAY"; 
        		break;
		case 2: result = "TUESDAY";
        		break;
		case 1: result = "MONDAY" ;//1 means monday. //no need to give break :)
		}
	 	
	 	return result;
	}
    
    public static boolean isValidDate(int yyyy,int mm,int dd) {
    	if(yyyy<0){
    		System.out.println("Invalid year.");
    		return false;
    	}else if(mm<=0 || mm>12){
    		System.out.println("Invalid month.");
    		return false;
    	}else if(dd<=0 || dd>31){
    		System.out.println("Invalid date.");
    		return false;
    	}else if((mm==4 || mm==6 || mm==9 || mm==11) && dd>30){ //jan(1)/mar(3)/may(5)/jul(7)/Aug(8)/Oct(10)/Dec(12):31, feb(2):28/29 
    		System.out.println("Invalid date for the given month.");
    		return false;
    	}else if(mm==2 && ((!isLeapYear(yyyy) && dd>28) || (isLeapYear(yyyy) && dd>29))){ 
    		System.out.println("Invalid date for given month.");
    		return false;
    	}
    		return true;
	}
    public static boolean isLeapYear(int yyyy) {
    	if((yyyy%4==0 && yyyy%100!=0) || yyyy%400==0)//Some year divisible by 4 but leap year(ex: 1700,1800, etc). so added another condition. 
    		return true;
    	return false;
	}
}
