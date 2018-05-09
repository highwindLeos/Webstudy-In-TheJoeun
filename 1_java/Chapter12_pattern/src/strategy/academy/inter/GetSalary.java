package strategy.academy.inter;

public class GetSalary implements IPay {

	@Override
	public void pay() {
		System.out.println("월급을 받습니다.");
	}

}
