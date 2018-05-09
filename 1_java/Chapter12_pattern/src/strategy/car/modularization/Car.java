package strategy.car.modularization;
import strategy.car.inter.*;
public abstract class Car {
	private IEngine engine;
	private IKm     km;
	private IFuel   fuel;
	// 드라이브, 엔진, 연비, 연료
	// 모양(추상메소드)
	public void drive() {
		System.out.println("기본적으로 드라이브할 수 있다");
	}
	public abstract void shape();
	public void isEngine() {engine.engine();}
	public void isKm() {km.km();}
	public void isFuel() {fuel.fuel();}
	// setter & getter
	public IEngine getEngine() {
		return engine;
	}
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public IKm getKm() {
		return km;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
	public IFuel getFuel() {
		return fuel;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
}
