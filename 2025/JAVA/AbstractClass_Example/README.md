# Controller Example  
이 코드는 추상 클래스와 다형성을 활용하여 `TV`와 `Radio` 객체의 전원 상태를 출력하는 간단한 Java 프로그램입니다.  
Java의 상속과 오버라이딩 개념을 연습하기 위한 예제입니다.

## Technologies Used
- Java
- 추상 클래스 (`abstract`)
- 상속 (`extends`)
- 오버라이딩 (`@Override`)
- 다형성 (Polymorphism)
- 배열과 향상된 for문

## Main Features
- `Controller`라는 추상 클래스를 정의하고, 자식 클래스들이 `getName()`을 오버라이딩하도록 강제합니다.
- 전원 상태를 관리하는 `power` 변수를 통해 각 기기의 작동 여부를 출력합니다.
- `show()` 메서드를 통해 자식 클래스의 이름과 전원 상태를 함께 출력합니다.
- `Controller[]` 배열에 다양한 기기를 넣고, 향상된 for문으로 공통된 인터페이스(`show()`)를 통해 처리합니다.

## Example Output
![image](https://github.com/user-attachments/assets/00c8fcf1-8eac-4eba-af08-c6467f29ead2)

## Learning Points
- 추상 클래스는 직접 객체를 생성할 수 없고, 자식 클래스에서 구현하여 사용해야 함을 배웠습니다.
- `abstract` 메서드를 자식 클래스에서 반드시 오버라이딩해야 한다는 규칙을 익혔습니다.
- 부모 타입 배열(Controller[])에 자식 객체(TV, Radio)를 담아 다형성을 활용하는 방법을 이해했습니다.
- 향상된 for문을 통해 객체 배열을 순회하고, 공통된 메서드를 호출하는 방법을 배웠습니다.
- `super()` 키워드를 통해 부모 클래스의 생성자를 호출하는 방법을 익혔습니다.
