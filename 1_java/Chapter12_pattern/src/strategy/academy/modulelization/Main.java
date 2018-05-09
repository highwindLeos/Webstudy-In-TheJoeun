package strategy.academy.modulelization;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student("30301", "������", "��ȭ��");
		Student st2 = new Student("30302", "������", "Java��");
		Gangsa gs1 = new Gangsa("J01", "ȫ�浿", "java");
		Gangsa gs2 = new Gangsa("J02", "��ö��", "db");
		Staff s = new Staff("A01", "������", "�������");

		Person[] person = { st1, st2, gs1, gs2, s };

		System.out.println("�����ð��̴� �� ���սô�");
		System.out.println();
		for (Person p : person) {
			p.job();
		}
		System.out.println("----------------------------------------");
		System.out.println("������ �� ������ �� ����");
		System.out.println();
		for (Person p : person) {
			p.pay();	
		}
		System.out.println("----------------------------------------");
		System.out.println("�ñ��ϸ� ����Ʈ");
		System.out.println();
		for (Person p : person)
			p.print();
	}

}
