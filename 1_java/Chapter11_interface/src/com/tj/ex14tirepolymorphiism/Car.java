package com.tj.ex14tirepolymorphiism;

public class Car {
	Tire[] tires = { 
			new HankoookTire(), 
			new HankoookTire(), 
			new HankoookTire(), 
			new HankoookTire() 
			};
	
	void run(){
		for (Tire tTemp : tires) {
			tTemp.roll();
		}
	}

}
