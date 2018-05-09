package com.tj.ex2map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex1HashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>(); // <ket type, date type> �ַ� wrapper ��ü�� �ִ´�.
		
		hashMap.put(3, "str3");// HashMap �� �����͸� �Է�. key ���� �ֱ⶧���� ������ �ǹ̰� ����.
		hashMap.put(0, "str0");  
		hashMap.put(1, "str1");
		hashMap.put(2, "str2"); 
		
		
		System.out.println(hashMap.toString());
//		System.out.println("key �� 2�� data" + hashMap.get(new Integer(2)));
		System.out.println("key �� 2�� data" + hashMap.get(2));
		
		hashMap.remove(2); // key ���� 2�� �����͸� ����
		System.out.println("key �� 2 ������ " + hashMap);
		
		hashMap.clear(); // �Էµ� �����͸� ��� ����
		System.out.println("clear() �� " + hashMap);

		hashMap.put(3, "�̵���");// HashMap �� �����͸� �Է�. key ���� �ֱ⶧���� ������ �ǹ̰� ����.
		hashMap.put(0, "ȫ�浿");  
		hashMap.put(1, "�赿��");
		hashMap.put(2, "�̼���"); 
		hashMap.put(4, "������");
		// hashmap �� for ������ ��� �����͸� ����Ҽ� �ִ°��� �ƴϴ�. key �� ������ �ƴҼ��� �ֱ⶧���̴�.
		// �׷��� Iterator(�ݺ���) �� keyset �� ����� �װ����� �����Ѵ�.
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		
		while(iterator.hasNext()) { // key���� ��� �����´�.
			Integer key = iterator.next(); // �������� ����Ų��.
			System.out.println(key + "Ű�� ���� " + hashMap.get(key));
		}
		
	}

}
