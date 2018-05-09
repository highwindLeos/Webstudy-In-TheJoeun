package pattern.singleton;

public class FirstClass {
	
	public FirstClass() { //생성자 함수
		SingletonClass singletonObject = SingletonClass.getSingletonClass();
		System.out.println("FirstClass 객체 ");
		System.out.println(singletonObject.getI());
		singletonObject.setI(200);
		System.out.println("i = " + singletonObject.getI());
	}
	
}
