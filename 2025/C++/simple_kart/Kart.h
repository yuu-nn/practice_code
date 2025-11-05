#pragma once
#include <iostream>
#include <string>
using namespace std;

class Kart {
private:
	string name;
	string color;
	int speed;
public:
	Kart();
	Kart(string, string, int);
	void show();

	string getName();
	string getColor();
	int getSpeed();

	~Kart();
};
