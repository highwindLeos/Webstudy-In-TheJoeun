// 1~ 45 까지 로또 번호 6개를 정렬한후 출력
public class LottoNum {

	public static void main(String[] args) {
		// 0.0 <= Math.ramdom()*45 < 45
		// 0 <= (int)(Math.random()*45) < 45
		// 1 <= (int)(Math.random()*45) +1 < 46

		int[] lotto = new int[7]; // 배열 생성
		int temp;
		int i, j; // 반복문 변수

		for (i = 0; i < lotto.length; i++) {
			do {
				// temp = 1~ 45 가지 정수 난수
				temp = (int) (Math.random() * 45) + 1; // 랜덤 값 반환 1~45.

				// temp 가 lotto[0]부터 lotto[i -1]까지 중복되는지
				for (j = 0; j < i; j++) {
					if (temp == lotto[j]) {
						break;
					} // 난수를 발생시켜 그 값이 0번재 부터 i - 1 번째 값과 중복되는지 확인.
				} // for - j
					// 중복이 되서 for 문을 빠져나오면 i != j
					// break 하여 나오지 않으면 i == j
			} while (i != j); // 중복을 제거하는 Do while : 중복값이 아니라는 조건.
			lotto[i] = temp;
		}

		for (i = 0; i < lotto.length; i++) {
			for (j = 0; j < lotto.length; j++) {

				if (lotto[i] < lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				} // 오름 차순 정렬

			}
		}

		System.out.print("Lotto 선택 숫자는 ");
		for (int lo : lotto) {
			System.out.print(lo + "\t");
		}
		System.out.print("보너스 숫자는 " + lotto[6] + "입니다.");
	}

}