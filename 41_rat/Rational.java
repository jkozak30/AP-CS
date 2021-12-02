/*
Team Orange Marshmellows: Nina Jiang, Diana Akhmedova, Julia Kozak // Duckies: Miss Alpaca, Ajax, Flopsy
APCS pd08
HW41 -- Be Rational
2021-12-01
Time Spent: 0.5 hrs
*/

/*
DISCO: you can only call the default constructor in an overloaded constructor in the first statement;
       avoid division in writing multiply/divide methods (for divide, multiply by the reciprocal);
       you can access another instance's private variable within a method of the same class type 
QCC:   what is problematic about calling a default constructor later in the overloaded constructor?
*/

public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational() {
		numerator = 0;
		denominator = 1;
	}
	
	public Rational(int num, int den) {
		if (den != 0) {
			denominator = den;
		} else {
			numerator = 0;
			denominator = 1;
		}
		numerator = num;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public double floatValue() {
		return (double)numerator/denominator;
	}
	
	public void multiply(Rational n) {
		numerator = numerator * n.numerator;
		denominator = denominator * n.denominator;
	}
	
	public void divide(Rational n) {
		numerator = numerator * n.denominator;
		denominator = denominator * n.numerator;
	}
	
	public static void main(String[] args) {
		Rational a = new Rational(1, 7);
		Rational b = new Rational(2, 6);
		System.out.println(a.toString());

		System.out.println(a.floatValue());

		a.multiply(b);
		System.out.println(a.toString());

		a.divide(b);
		System.out.println(a.toString());
	}
}
