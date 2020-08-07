package com.raushan.grab;

public class GrabTest {

	public static void main(String[] args) {
		//int result= solution2(new int[]{5, -2, 3, 8, 6});
		String str= solution(3, 2, new int[]{2, 1, 1, 0, 1});
		System.out.println("result: "+str);
		 
	}//5,79,28,84,321‬
	
	public static String solution(int U, int L, int []C){

//      int U = 3;
//      int L = 2;
//      int []C = {2,1,1,0,1};

      String UStr = "";
      String LStr = "";

      for (int i=0; i<C.length; i++) {
          int s = C[i];
          if (s == 2) {

              UStr = UStr + "1";
              LStr = LStr + "1";

              U = U-1;
              L = L-1;

          } else if (s == 1){
              
              if (U > L) {
                  UStr = UStr + "1";
                  LStr = LStr + "0";
                  U = U-1;
              } else {
                  UStr = UStr + "0";
                  LStr = LStr + "1";
                  L = L-1;
              }
              
          } else {
              UStr = UStr + "0";
              LStr = LStr + "0";
          }
      }

     /* if (!UStr.trim().equals("") && !LStr.trim().equals(""))*/ 
      if (U==0 && L==0){
          return UStr + "," +LStr;
      } else {
          return "IMPOSSIBLE";
      }
  }
	
	public static int solution(int[] T) {
		
		int midLenth= T.length/2, length= T.length;
		int result = 0, previousTemp=0;
		for(int i=0;i<length;i++){
			if(i!=0){
				if(previousTemp>T[i])
					++result;
				else if(midLenth>=i){
					++result;
				}else 
					break;
			}else{// assuming 1st temp winter
				++result;
			}
			previousTemp = T[i];
		}
		
		return result;
		
	}
}
