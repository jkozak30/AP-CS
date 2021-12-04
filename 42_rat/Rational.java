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
		this();
		if (den != 0) {
			denominator = den;
			numerator = num;
		}
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
		if (n.numerator != 0) {
			numerator = numerator * n.denominator;
			denominator = denominator * n.numerator;
		}
	}
	
	public void add(Rational n) {
		denominator = denominator * n.denominator;
		numerator = numerator * n.denominator + n.numerator * denominator;
	}
	
	public void subtract(Rational n) {
		denominator = denominator * n.denominator;
		numerator = numerator * n.denominator - n.numerator * denominator;
	}
	
	public int gcd() {
		for (int i=numerator; i>0; i--) {
			if (numerator % i == 0 && denominator % i ==0) {
				return i;
			}
		}
		return 1;
	}
	
	public void reduce() {
		numerator = numerator / gcd();
		denominator = denominator / gcd();
	}
	
	public int compareTo(Rational q) {
		Rational reduceThis = new Rational(this.numerator, this.denominator);
		Rational reduceQ = new Rational(q.numerator, q.denominator);
		reduceThis.reduce();
		reduceQ.reduce();
		if (reduceThis.numerator == reduceQ.numerator && reduceThis.denominator == reduceQ.denominator) {
			return 0;
		} else if (this.floatValue() > q.floatValue()) {
			return 1;
		} else {
			return -1;
		}
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

		a.reduce();
		b.reduce();
		System.out.println(b.toString());

		Rational c = new Rational(a.numerator, a.denominator);
		a.add(b);
		System.out.println(a.toString());
		b.add(c);
		System.out.println(b.toString());
		System.out.println(a.compareTo(b));
		b.subtract(c);
		System.out.println(b.toString());
	}
}
