package pattern.singleton;

public class Main {

	public static void main(String[] args) {
		FirstClass obj1 = new FirstClass();
		SecondClass obj2 = new SecondClass();
		// �θ��� �����ڸ� ���ο� ������ ��ȯ���� �ڱ��ڽ� Ŭ�������� public �Լ��� ȣ���ؼ� ��ü�� �����ؼ� 
		// ������ ������ �־���.
		SingletonClass singObj = SingletonClass.getSingletonClass(); 
		
		System.out.println("main() �޼ҵ忡�� sington ��ü");
		System.out.println(singObj.getI());
		
	}

}
