package edu.kh.poly.ex1.model.vo;

public class Tesla extends Car { // 전기차
	
	private int batteryCapactiy; // 배터리 용량
	
	public Tesla() {
		super(); // 부모 생성자 car
	}
	
	// 매개변수 생성자
	public Tesla(String engine, String fuel, int wheel, int batteryCapactiy) {
		super(engine, fuel, wheel);
		this.batteryCapactiy = batteryCapactiy;
	}
	// getter / setter
	public int getBatteryCapactiy() {
		return batteryCapactiy;
	}
	public void setBatteryCapactiy(int batteryCapactiy) {
		this.batteryCapactiy = batteryCapactiy;
	}
	
	// Car.toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString()+" / "+ batteryCapactiy; 
	}
	
}
