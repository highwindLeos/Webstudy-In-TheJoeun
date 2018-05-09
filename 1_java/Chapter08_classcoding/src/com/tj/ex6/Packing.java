package com.tj.ex6;

// 주차장 들어오고 나가고 결과
public class Packing {
	public static int HOURLYPARKINGRATE = 2000;
	
	private String carNum;
	private int inTime;
	private int outTime;
	private int price;

	public Packing() {
		System.out.println("입차시간이 입력되지 않았습니다.");
	}

	public Packing(String carNum, int inTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.price = HOURLYPARKINGRATE;
		System.out.println(carNum + "님 어서오세요. 입차시간 : " + inTime + "시 입니다. 주차요금은 시간 당 " + price + " 원");
	}

	// user method
	public void outPrint() {
		price = (outTime - inTime) * HOURLYPARKINGRATE;
		System.out.printf("출차 하셨습니다.\n 차번호*** %s *** \n 입차시간 %d시\n 출차시간 %d시\n 주차요금 %d원 \n", 
							carNum, inTime, outTime, price);
		System.out.println();
	}

	// getter setter
	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
