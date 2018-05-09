package strategy.car.inter;
public class EngineLow implements IEngine {
	@Override
	public void engine() {
		System.out.println("저급 엔진입니다");
	}
}
