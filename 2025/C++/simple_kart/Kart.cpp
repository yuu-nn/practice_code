#include <iostream>
#include <string>
using namespace std;

#include "Kart.h"

Kart::Kart() {
	name = "익명";
	color = "검정";
	speed = 0;
}

Kart::Kart(string n, string c, int s) {
	name = n;
	color = c;
	speed = s;
}

void Kart ::show() {
	cout << name << ", " << color << ", " << speed << endl;
}

Kart::~Kart() {
	cout <<  name << "을/를 폐차하였습니다." << endl;
}

string Kart::getName() { return name; }
string Kart::getColor() { return color; }
int Kart::getSpeed() { return speed; }

