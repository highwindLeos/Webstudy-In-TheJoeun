package pattern.singleton;

public class FirstClass {
	
	public FirstClass() { //������ �Լ�
		SingletonClass singletonObject = SingletonClass.getSingletonClass();
		System.out.println("FirstClass ��ü ");
		System.out.println(singletonObject.getI());
		singletonObject.setI(200);
		System.out.println("i = " + singletonObject.getI());
	}
	
}
