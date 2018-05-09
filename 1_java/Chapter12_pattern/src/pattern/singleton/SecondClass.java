package pattern.singleton;

public class SecondClass {
	
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getSingletonClass();
		System.out.println("Second °´Ã¼ ");
		System.out.println("i = "+singletonObject.getI());
		
	}

}
