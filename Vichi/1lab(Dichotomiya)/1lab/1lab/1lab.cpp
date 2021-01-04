#include <iostream>

#define A 1;
#define B 100;
#define C 5;
#define D 9;

double a = 1;
double b = 100;
double c = 5;
double d = 9;


using namespace std;

double func(double x) {
	return (a * x * x * x + b * x * x + c * x + d);
}

bool closeEnought(double x, double y, double e) {
	if (abs(x - y) < e) return true;
	return false;
}

double average(double x, double y) {
	return (x + y) / 2;

}

double search(double a, double b, double e) {
	double midPoint = average(a, b);
	double negPoint;
	double posPoint;
	if (func(a) < 0) {
		negPoint = a;
		posPoint = b;
	}
	else {
		negPoint = b;
		posPoint = a;
	}

	if (closeEnought(negPoint, posPoint, e)) return midPoint;
	double testValue = func(midPoint);
	if (testValue > 0) return search(negPoint, midPoint);
	else if (testValue < 0) return search(midPoint, posPoint);
	return midPoint;
}


void printUr(double a, double b, double c, double d) {
	cout << a << "x^3 + " << b << "x^2 + " << c << "x + " << d << " = 0"<< endl;
}

int main()
{
	double a, b, c, d, e, del;
	a = A; b = B; c = C; d = D;
	cin >> e >> del;

	printUr(a, b, c, d);

    //cout << "Hello World!\n";
	return 0;
}