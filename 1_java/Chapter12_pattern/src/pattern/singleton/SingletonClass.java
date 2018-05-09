package pattern.singleton;

public class SingletonClass {
	private static SingletonClass SINGLETON_INSTANCE;
	private int i = 10;
	
	private SingletonClass() {} // private �� �����ؼ� �����ڰ� �ܺο��� ���پȵ�.
	// �� Ŭ������ ��ü(instance) �� ���ο����� ������ �Լ��� ȣ�� �Ҽ� �ִ�.
	public static SingletonClass getSingletonClass() {
		// ��ü�� �����Ǳ� ���� �����Ϳ����� Ŭ���� ���¿��� �ٷ� ���� ������ �޼ҵ�.
		if (SINGLETON_INSTANCE == null) {
			SINGLETON_INSTANCE = new SingletonClass(); // ��ü������ �� ���ǹ��ȿ��� �Ѵ�.
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
