
public class DefaultTest implements T2{
 public static void main(String[] args) {
	 new DefaultTest().test(); 
}
}


interface T1 {
	default void test(){
		System.out.println("from T1");
	}
}

interface T2 extends T1 {
	default void test(){
		System.out.println("from T2");
	}
}