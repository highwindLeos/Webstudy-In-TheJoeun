package com.tj.ex05default;
// ��� , �߻� �޼ҵ� default �޼ҵ�, static �޼ҵ�
public interface RemoteControl {
	public int MAX_VOLUME = 20; // ��� (final ����)
	public int MIN_VOLUME = 10; // ���
	
	public void turnOn();// �߻� �޼ҵ� : �������̽��� ��� �޼ҵ�� �߻� �޼ҵ�
	public void turnOff();// �߻� �޼ҵ�
	public void setVolum(int volume);
	
	public default void setMute(boolean mute) { ////default keyword :�������̽� �ȿ��� ������ �ִ� �Լ��� ����. 
		if(mute) {
			System.out.println("����ó��");
		} else {
			System.out.println("���Ұ� ó�� ����");
		}
	} 
	
	public static void changeBattery() { // static �޼ҵ� : ��ü�� ������ �ʾƵ� ȣ�� ����.
		System.out.println("�������� �ٲߴϴ�.");
	}
	
}
