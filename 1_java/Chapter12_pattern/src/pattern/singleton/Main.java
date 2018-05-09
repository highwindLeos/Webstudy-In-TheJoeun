package pattern.singleton;

public class Main {

	public static void main(String[] args) {
		FirstClass obj1 = new FirstClass();
		SecondClass obj2 = new SecondClass();
		// 부모의 생성자를 내부에 정의한 반환형이 자기자신 클래스형인 public 함수를 호출해서 객체를 생성해서 
		// 참조형 변수에 넣었다.
		SingletonClass singObj = SingletonClass.getSingletonClass(); 
		
		System.out.println("main() 메소드에서 sington 객체");
		System.out.println(singObj.getI());
		
	}

}
