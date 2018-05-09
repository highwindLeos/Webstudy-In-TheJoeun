package strategy.car.inter;
public class FuelDiesel implements IFuel {
	@Override
	public void fuel() {
		System.out.println("경유 차입니다");
	}
}