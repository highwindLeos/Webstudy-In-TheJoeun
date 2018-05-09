// 1~ 45 ���� �ζ� ��ȣ 6���� �������� ���
public class LottoNum {

	public static void main(String[] args) {
		// 0.0 <= Math.ramdom()*45 < 45
		// 0 <= (int)(Math.random()*45) < 45
		// 1 <= (int)(Math.random()*45) +1 < 46

		int[] lotto = new int[7]; // �迭 ����
		int temp;
		int i, j; // �ݺ��� ����

		for (i = 0; i < lotto.length; i++) {
			do {
				// temp = 1~ 45 ���� ���� ����
				temp = (int) (Math.random() * 45) + 1; // ���� �� ��ȯ 1~45.

				// temp �� lotto[0]���� lotto[i -1]���� �ߺ��Ǵ���
				for (j = 0; j < i; j++) {
					if (temp == lotto[j]) {
						break;
					} // ������ �߻����� �� ���� 0���� ���� i - 1 ��° ���� �ߺ��Ǵ��� Ȯ��.
				} // for - j
					// �ߺ��� �Ǽ� for ���� ���������� i != j
					// break �Ͽ� ������ ������ i == j
			} while (i != j); // �ߺ��� �����ϴ� Do while : �ߺ����� �ƴ϶�� ����.
			lotto[i] = temp;
		}

		for (i = 0; i < lotto.length; i++) {
			for (j = 0; j < lotto.length; j++) {

				if (lotto[i] < lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				} // ���� ���� ����

			}
		}

		System.out.print("Lotto ���� ���ڴ� ");
		for (int lo : lotto) {
			System.out.print(lo + "\t");
		}
		System.out.print("���ʽ� ���ڴ� " + lotto[6] + "�Դϴ�.");
	}

}