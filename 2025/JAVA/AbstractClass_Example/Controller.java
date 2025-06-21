public abstract class Controller { // 추상 클래스다. 상속을 해서 사용 가능하다.
	boolean power; // true면 전원이 켜지고, false면 전원이 꺼진다.

	public Controller(boolean power) {
		this.power = power; // power 값을 초기화한다.
	}

	public void show() {
		String status; // power의 상태에 따라 메세지를 출력하기 위해 문자열을 저장할 수 있는 변수를 선언한다.

		if (power) {
			status = "켜졌습니다."; // power 가 true면 켜진다.
		} else {
			status = "꺼졌습니다."; // power 가 false면 꺼진다.
		}

		System.out.println(getName() + "가 " + status); // getName()은 자식 클래스에서 구현 될 메서드이다.
	}

	public abstract String getName();
	// 추상 메서드를 선언한다. 내용은 정의하지 않았다. 자식 클래스에서 강제로 오버라이딩 하도록 하는 코드이다.

}
