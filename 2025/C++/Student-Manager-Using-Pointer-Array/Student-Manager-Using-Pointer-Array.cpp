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

	void setInfo(string, int, string);

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
string Student::getName() { return name; }
int Student::getNumber() { return number; }
string Student::getTel() { return tel; }

void Student::showInfo() {
	cout << "이름: " << name << ", 학번: " << number << ", 연락처: " << tel << endl;
}

int main() {
	Student* p = new Student[3];

	string name, tel;
	int number;

	cout << "[학생 정보 입력]" << endl;
	for (int i = 0; i < 3; i++) {
		cout << i+1 << "번째 학생 이름, 학번, 연락처를 입력하세요: ";
		cin >> name >> number >> tel;

		p[i].setInfo(name, number, tel);

	}
	cout << endl << "[학생 정보 목록]" << endl;

	for (int i = 0; i < 3; i++) {
		p[i].showInfo();
	}
	delete [] p;
	return 0;
}
