# Exception_Example
이 코드는 Java의 `StringTokenizer` 클래스를 사용하여 문자열을 지정한 구분자(delimiter)로 나누고, 예외 처리 흐름을 실습하는 예제입니다.

## Technologies Used
- Java
- `StringTokenizer`
- 예외 처리 (`try-catch`, `throws`)
- 무한 반복문
- `NoSuchElementException`

## Main Features
### TokenPrintTest.java
- 문자열 `"of the people, by the people, for the people"`를 `", "` 기준으로 분리합니다.
- `nextToken()`을 통해 토큰을 하나씩 꺼냅니다.
- 더 이상 토큰이 없을 때 발생하는 `NoSuchElementException`을 `try-catch` 문으로 직접 처리합니다.

### TokenPrintTest2.java
- 구조는 거의 같지만 예외 처리를 `showTokens` 메서드가 아닌 `main` 메서드에서 수행합니다.
- `showTokens()` 메서드에서 `throws NoSuchElementException`을 선언하여 예외를 호출한 쪽으로 던집니다.
- 예외 발생 위치와 처리 방식의 차이를 비교하며 예외 전달 구조를 학습할 수 있습니다.

## Example Output
![image](https://github.com/user-attachments/assets/bbf6b885-439a-43bd-97c0-d56c0c8cb55c)

## Learning Points
- 문자열을 특정 구분자로 분리하는 방법을 익혔습니다.
- `StringTokenizer`는 토큰이 남아있는지 확인하지 않고 `nextToken()`을 호출하면 `NoSuchElementException`이 발생함을 확인했습니다.
- 예외를 직접 처리할 수도 있고, `throws`를 통해 호출자에게 넘길 수도 있다는 점을 배웠습니다.
- 메서드 설계 시 예외 처리 위치에 따라 코드의 흐름과 책임이 달라질 수 있음을 이해했습니다.
