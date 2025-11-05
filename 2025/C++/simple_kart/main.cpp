#include <iostream>
#include <string>
using namespace std;

#include "Kart.h"

int main() {
	Kart Kart1;
	Kart Kart2("슈퍼카", "파랑", 200);
	Kart Kart3("트럭", "노랑", 100);

	cout << "Racing in KartRider" << endl << endl;
	cout << "1번째 : " << Kart1.getName() << "," << Kart1.getColor() << "," << Kart1.getSpeed() << endl;
	cout << "2번째 : " << Kart2.getName() << "," << Kart2.getColor() << "," << Kart2.getSpeed() << endl;
	cout << "3번째 : " << Kart3.getName() << "," << Kart3.getColor() << "," << Kart3.getSpeed() << endl;

	return 0;

}
