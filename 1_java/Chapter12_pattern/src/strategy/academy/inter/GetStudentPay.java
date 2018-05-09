package strategy.academy.inter;

public class GetStudentPay implements IPay {

	@Override
	public void pay() {
		System.out.println("교육급여를 받습니다.");
	}

}
