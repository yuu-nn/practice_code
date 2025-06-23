import java.util.NoSuchElementException;
//토큰이 남아있지 않을 때 발생하는 예외 클래스를 사용하기 위해 import 한다.
import java.util.StringTokenizer;

public class TokenPrintTest {
	public static void main(String[] args) {
		String s = "of the people, by the people, for the people"; // 이 문장을 나눈다.
		showTokens(s, ", "); // 콤마 기준으로 문장을 나눈다. showTokens 메서드를 호출한다.
		// showTokens : 구분자를 기준으로 하나씩 출력해준다. (여기에서 구분자는 , 이다 )
	}

	static void showTokens(String s, String delimiter) {
		StringTokenizer st = new StringTokenizer(s, delimiter); // , 로 문자열을 나눈다.

		try { // try-catch 문을 이용한다.
			while (true) { // 무한 반복문을 이용한다.
				System.out.println(st.nextToken()); // 얼마나 남았는지 확인하지 않고 토큰을 바로 꺼낸다.
				// 마지막 토큰 이후에도 계속 nextToken()을 호출하면 예외가 발생하게 된다.
			}
		} catch (NoSuchElementException e) { // 토큰이 더 이상 없을 때 발생하는 예외를 catch한다.
			System.out.println("예외 발생"); // 예외가 발생하면 이 메시지를 출력한다.
		}
	}
}
