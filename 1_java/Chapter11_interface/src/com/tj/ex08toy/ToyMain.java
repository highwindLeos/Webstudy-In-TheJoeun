package com.tj.ex08toy;

public class ToyMain {

	public static void main(String[] args) {
		IToy pooh = new PoohToy(); // 위의 단계의 타입의 변수로 객체를 넣을수 있다.
		// IMoveArmLeg pooh = new PoohToy();

		IToy mazinga = new Mazinger();
		// Maginga maginga = new Maginga();
		// IMoveArmLeg maginga = new Maginga();

		IToy airplane = new Airplane();
		// Airplane airplane = new Airplane();
		// ILight airplane = new Airplane();

		IToy[] toys = { pooh, mazinga, airplane };

		for (IToy tTemp : toys) {
			System.out.println(tTemp.getClass().toString());
		}
		System.out.println("------------------------------");
		for (int i = 0; i < toys.length; i++) {
			System.out.println(toys[i].getClass().getName());
		}

	}

}
