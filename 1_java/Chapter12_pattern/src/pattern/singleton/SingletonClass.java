package pattern.singleton;

public class SingletonClass {
	private static SingletonClass SINGLETON_INSTANCE;
	private int i = 10;
	
	private SingletonClass() {} // private 로 설정해서 생성자가 외부에서 접근안됨.
	// 이 클래스의 객체(instance) 는 내부에서만 생성자 함수를 호출 할수 있다.
	public static SingletonClass getSingletonClass() {
		// 객체가 생성되기 저에 데이터영역의 클래스 상태에서 바로 접근 가능한 메소드.
		if (SINGLETON_INSTANCE == null) {
			SINGLETON_INSTANCE = new SingletonClass(); // 객체생성을 이 조건문안에서 한다.
		}
		return SINGLETON_INSTANCE;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
