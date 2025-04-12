public class Football {
	public static void main(String[] args) {
		System.out.println(onField(10));
		System.out.println(onField(13));
	}

	public static String onField(int shirtNum) {
		return switch (shirtNum) {
		// switch expression을 사용하였다. switch 자체가 값을 반환할 수 있는 구조이다.
		case 1 -> "goalie"; // ->(화살표)를 사용하여 case가 어떤 값을 반환하는지 지정해준다.
		case 2 -> "left back";
		case 3, 4 -> "center back"; // 여러 케이스가 같은 값일때는 쉼표를 사용하여 한 줄로 처리할 수 있다.
		case 5 -> "right back";
		case 6, 7, 8 -> "midfielder";
		case 9 -> "left wing";
		case 10 -> "striker";
		case 11 -> "right wing";
		default -> "unknown"; // 어떤 case에도 속하지 않는 경우에 실행되는 default를 사용했다.
		}; // switch (..){..} 자체가 하나의 표현식이다. 따라서 블록을 마무리 하고 싶다면 세미콜론을 써줘야 한다.
	}

}
