package inheritance;

class Car {
	int speed;
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

class ElectricCar extends Car {
	int battery;
	
	public void charge(int amount) {
		battery += amount;
	}
}

public class Inheritance {
	
	public static void main(String[] args) {
		ElectricCar obj = new ElectricCar();
		obj.speed = 10;
		obj.setSpeed(60);
		obj.charge(10);
	}

}
