import java.util.NoSuchElementException;
//토큰이 남아있지 않을 때 발생하는 예외 클래스를 사용하기 위해 import 한다.
import java.util.StringTokenizer;

public class TokenPrintTest2 {
	public static void main(String[] args) {
		String s = "of the people, by the people, for the people"; // 이 문장을 나눈다.

		try {
			showTokens(s, ", "); // 토큰을 출력하는 메서드이다. 이 부분에서 예외가 발생할 수 있다.
		} catch (NoSuchElementException e) { // 예외가 발생하면 여기에서 잡는다.
			System.out.println("예외 발생"); // 메시지를 출력한다.
		}
	}

	static void showTokens(String s, String delimiter) throws NoSuchElementException {
		// 예외가 발생하면 throws 키워드로 예외를 이 메서드를 호출한 쪽(main)으로 전달한다.
		StringTokenizer st = new StringTokenizer(s, delimiter); // 콤마 기준으로 분리한다.

		while (true) { // 무한 반복문을 돌린다.
			System.out.println(st.nextToken()); // 더 이상 토큰이 없을 때 예외가 발생하게 된다.
		}
	}
}
