package newPackageTasks;


public class VehicleSpeedup extends Car {

	public static void main(String[] args) {
		Car cara = new Car();
		Bicycle bike = new Bicycle();
		cara.currSpeed = 25;
		bike.currSpeed = 25;
		
		cara.speedUP();
		bike.speedUP();
		
		System.out.println("Car current speed: " + cara.currSpeed);
		System.out.println("Bike current speed: " + bike.currSpeed);
		
		Bicycle bike2 = new Car();
		bike2.currSpeed = 25;
		bike2.speedUP();
		
		System.out.println("Car current speed: " + cara.currSpeed);
		System.out.println("Bike current speed: " + bike.currSpeed);
		System.out.println("Bike 2 current speed: " + bike2.currSpeed);
	}


}