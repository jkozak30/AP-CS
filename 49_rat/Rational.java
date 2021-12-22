/*
Team Orange Marshmellows: Julia Kozak, Nina Jiang, Diana Akhmedova // Duckies: Flopsy, Miss Alpaca, Ajax
APCS pd08
HW42 -- Be More Rational
2021-12-06
Time Spent: 0.5 hrs
*/

/*
DISCO: set placeholder variables for the values in methods like gcd(), or else reduce will evaluate the method value multiple times;
       would it be problematic to compare the floating point values of two Rationals, if they're equal (as in, could there be rounding errors)?
QCC:   would it be possible to create a method that changes variable values for more than one instance (ex, multiply operates on both the calling and parameter instances)?
*/

public class Rational implements Comparable {
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

	public void multiply(Rational q) {
		numerator = numerator * q.numerator;
		denominator = denominator * q.denominator;
	}

	public void divide(Rational q) {
		if (q.numerator != 0) {
			numerator = numerator * q.denominator;
			denominator = denominator * q.numerator;
		}
	}

	public void add(Rational q) {
		int d = denominator;
		denominator = denominator * q.denominator;
		numerator = numerator * q.denominator + q.numerator * d;
	}

	public void subtract(Rational q) {
		int d = denominator;
		denominator = denominator * q.denominator;
		numerator = numerator * q.denominator - q.numerator * d;
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
		int gcd = this.gcd();
		numerator = numerator / gcd;
		denominator = denominator / gcd;
	}

	public int compareTo(Object q) {
		if (q instanceof Rational) {
		Rational qRat = (Rational)q;
		Rational reduceThis = new Rational(this.numerator, this.denominator);
		Rational reduceQ = new Rational(qRat.numerator, qRat.denominator);
		reduceThis.reduce();
		reduceQ.reduce();
		if (reduceThis.numerator == reduceQ.numerator && reduceThis.denominator == reduceQ.denominator) {
			return 0;
		} else if (this.floatValue() > qRat.floatValue()) {
			return 1;
		} else {
			return -1;
		}
		} else {
			throw new ClassCastException ("\ncompareTo() input is not a Rational");
		}
	}
	
	public boolean equals(Object other) {
		if (this.compareTo(other) == 0) {
			return true;
		} else { 
			return false;
		}
	}

	public static void main(String[] args) {
		Object a = new Rational(1, 2);
		Rational b = new Rational(2, 3);
		Rational d = new Rational(2, 3);
		Object c = new Object();
		
		System.out.println(b.compareTo(a));
		
		System.out.println(b.equals(a));
		System.out.println(b.equals(d));
		
		System.out.println(b.compareTo(c));
	}
}

