package strategy.car.inter;

public class FuelHybrid implements IFuel {

	@Override
	public void fuel() {
		System.out.println("하이브리드 연료입니다");
	}
}
