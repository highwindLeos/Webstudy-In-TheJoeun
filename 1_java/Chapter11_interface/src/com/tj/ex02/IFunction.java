package com.tj.ex02;

// a 제품: DMB 송신 불가 , 3g , TV 리모콘 미탑재
// b 제품:DMB 송신 불가 , LTE , TV 리모콘 미탑재
// c 제품:DMB 송신 가능 , LTE , TV 리모콘 탑재
public interface IFunction {
	public void dmbRecive();

	public void lte();

	public void tvremoteControl();
}
