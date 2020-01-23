import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class LamdaExpressionTest1 {

	public static void main(String[] args) {
		T t1 = arg -> arg.length();	
		t1.test("hgjghj");	
		
		Q q1= (s, y) -> System.out.println("hjghj");
		
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "raushan"));
		list.add(new Employee(2, "chandan"));
		list.add(new Employee(3, "bambam"));
		
		//here using lamda expression for comparator interface 
		Collections.sort(list,(e1,e2)-> e2.getName().compareTo(e1.getName()));//sorting based on name
		
		System.out.println("------name---------"+list);
		Collections.sort(list, (e1,e2)->e2.getId()-e1.getId());//sorting based on id
		System.out.println("-----id----------"+list);
		new Thread(()->System.out.println("--runnable--")).start();
		new Thread(()->{System.out.println("--callable--");
		
		}).start();
		
		B b =  new B();
		b.defaultMethod2();// default method available to object even though you don't override
		
	}
}

class B implements Q, T {
	public int test(String s){
		return 0;
	}
	public void defaultMethod(){// must be public. if it's in T & Q both then must override here
		System.out.println("From B class.");
		T.super.defaultMethod();//to call default method of T
	}
	
	@Override
	public void test(String s, int y) {
		// TODO Auto-generated method stub
		
	}
	
}

@FunctionalInterface
interface T {
	int test(String s);
	default void defaultMethod(){
            System.out.println("From T interface.");		
	}
	//can't override object class method 
/*default int hashCode(){
		return 10;
	}*/
}

@FunctionalInterface
interface Q {
	void test(String s, int y);
	default void defaultMethod(){
        System.out.println("From Q interface.");		
}
	default void defaultMethod2(){
        System.out.println("defaultMethod2 From Q interface.");		
}
}


