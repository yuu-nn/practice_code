#include <iostream>
using namespace std;

class Student {
private:
	string name;
	int number;
	string tel;

public:
	Student();
	~Student();

	void setInfo(string , int , string );

	string getName();
	int getNumber();
	string getTel();

	void showInfo();
};

Student::Student() {}

Student::~Student() {}
void Student::setInfo(string n, int num, string t) {
	name = n;
	number = num;
	tel = t;
}
string Student::getName() {return name;}
int Student::getNumber() { return number;}
string Student::getTel(){ return tel;}

void Student::showInfo() {
	cout << "이름: " << name << ", 학번: " << number << ", 연락처: " << tel<< endl;
}
	

int main() {
	Student students[3];

	Student* p = students; //==&students[0]

	students[0].setInfo("김민지", 20241001, "010-1111-2222");
	students[1].setInfo("박수현", 20241002, "010-3333-4444");
	students[2].setInfo("이도윤", 20241003, "010-5555-6666");

	/*
	(p+0)->setInfo("김민지", 20241001, "010-1111-2222");
	(p+1)->setInfo("박수현", 20241002, "010-3333-4444");

	p[0].setInfo("김민지", 20241001, "010-1111-2222");

	(*(p+0)).setInfo("김민지", 20241001, "010-1111-2222");
	(*(p+1)).setInfo("박수현", 20241002, "010-3333-4444");
	*/

	for (int i = 0; i < 3; i++) {
		students[i].showInfo();
	}

return 0;
}
