//you can run this
interface MainTest{
	public static void main(String[] args) {
		System.out.println("static meethod of interface: main().");
		test2();
		//defaultTest();
	}
	static void test2(){
		System.out.println("static meethod of interface: test2()");
	}
	default void defaultTest(){
		System.out.println("non static method of interface: test2()");
	}
}