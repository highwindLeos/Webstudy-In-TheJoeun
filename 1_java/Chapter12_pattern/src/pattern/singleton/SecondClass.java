package pattern.singleton;

public class SecondClass {
	
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getSingletonClass();
		System.out.println("Second ��ü ");
		System.out.println("i = "+singletonObject.getI());
		
	}

}
