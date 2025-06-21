public class Radio extends Controller {
	// Radio 클래스는 Controller 클래스를 상속받는다.
	// Radio 클래스는 Controller 클래스 기능을을 그대로 쓸 수 있다.

	public Radio(boolean power) {
		super(power); // 부모 클래스의 생성자를 호출하여 전원 상태를 설정한다.
	}

	@Override
	public String getName() { // 부모 클래스에서 정의한 추상 메서드인 getName()을 오버라이딩한다.
		return "라디오"; // "라디오" 라는 이름을 반환한다.
	}
}
