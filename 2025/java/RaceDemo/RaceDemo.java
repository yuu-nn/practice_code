class Car {
	private final int speed;
	private final int batteryDrain;
	private int metersDriven = 0;
	private int batteryLevel = 100;

	public Car(int speed, int batteryDrain) {
		this.speed = speed;
		// 매개변수 speed의 값을 이 클래스의 speed로 저장한다.
		// 이때 변수 이름이 같기에 혼란이 없도록 this.를 붙여준다.
		this.batteryDrain = batteryDrain;
		// 매개변수 batteryDrain의 값을 이 클래스의 batteryDrain로 저장한다.
		// 이때 변수 이름이 같기에 혼란이 없도록 this.를 붙여준다.
	}

	public boolean batteryDrained() {
		// boolean은 논리형 자료형으로, 값이 참인지 거짓인지 판단한다.
		return batteryLevel < batteryDrain;
		// 배터리 레벨(batteryLevel)이 차량의 방전률(batteryDrain)보다 떨어졌을 때,
		// 즉 자동차가 주행할 수 없을 때 true를 반환한다.
	}

	public int distanceDriven() {
		return metersDriven; // 지금까지의 주행거리(metersDriven)를 반환한다.
	}

	public void drive() {
		if (batteryLevel >= batteryDrain) {
			// 배터리 레벨이 방전율보다 높거나 같다면 실행된다. 낮다면 주행이 불가하기에 if문은 실행되지 않는다.
			metersDriven += speed; // 차량의 속도만큼 주행거리가 증가한다.
			batteryLevel -= batteryDrain; // 방전율만큼 배터리가 감소한다.
		}
	}
}

class RaceTrack {
	private final int distance;

	public RaceTrack(int distance) {
		this.distance = distance;
		// 매개변수 distance의 값을 이 클래스의 distance로 저장한다.
		// 이때 변수 이름이 같기에 혼란이 없도록 this.를 붙여준다.
	}

	public boolean tryFinishTrack(Car car) {
		// boolean은 논리형 자료형으로, 값이 참인지 거짓인지 판단한다.
		while (!car.batteryDrained() && car.distanceDriven() < distance) {
			// while문을 사용하여 조건이 참인 동안 반복하도록 한다.
			// 배터리가 방전되지 않았고(not 연산자인 '!'를 사용하였다.),
			// 차의 현재까지 주행거리가 트랙의 길이보다 짧다면,
			car.drive(); // 주행을 계속 진행한다.
		}
		return car.distanceDriven() >= distance;
		// 차의 현재까지 주행거리가 트랙의 길이보다 길거나 같다면, 즉 트랙을 완주했다면 true를 반환한다. (boolean 형)
	}
}

public class RaceDemo {
	public static void main(String[] args) {
		int speed = 5;
		int batteryDrain = 2;
		var yellowcar = new Car(speed, batteryDrain);
		yellowcar.drive();
		System.out.println(yellowcar.distanceDriven());
		System.out.println(yellowcar.batteryDrained());

		int distance = 100;
		var greencar = new Car(speed, batteryDrain);
		var race = new RaceTrack(distance);
		System.out.println(greencar.distanceDriven());
		System.out.println(race.tryFinishTrack(greencar));
		System.out.println(greencar.distanceDriven());
	}
}
