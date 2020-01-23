
public class InterfaceDeaultKeyWordTest extends Thread implements A{

  
  public static void main(String[] args) {
	  InterfaceDeaultKeyWordTest obj = new InterfaceDeaultKeyWordTest();
	  //obj.run();args 
}
  
  
}

class classA {
	public void  run(){
		  System.out.println(" public together");
	  }
}

interface A {
	  public default void  run(){
		  System.out.println("default & public together");
	  }
}	
