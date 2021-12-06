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

		Rational Q = new Rational();
		System.out.print("default rational Q: ");
		System.out.println(Q.toString());

		Rational a = new Rational(1, 7);
		Rational b = new Rational(2, 6);
		System.out.print("a: ");
		System.out.println(a.toString());

		System.out.print("a approximated: ");
		System.out.println(a.floatValue());

		System.out.print("b: ");
		System.out.println(b.toString());

		System.out.print("a after multiplication with b: ");
		a.multiply(b);
		System.out.println(a.toString());
		System.out.print("ensure b is the same: ");
		System.out.println(b.toString());

		System.out.print("a after division with b: ");
		a.divide(b);
		System.out.println(a.toString());

		a.reduce();
		b.reduce();
		System.out.print("a after reduction: ");
		System.out.println(a.toString());
		System.out.print("b after reduction: ");
		System.out.println(b.toString());

		System.out.print("new rational c = a: ");
		Rational c = new Rational(a.numerator, a.denominator);
		System.out.println(c.toString());
		a.add(b);
		System.out.print("a = a + b: ");
		System.out.println(a.toString());
		System.out.print("b = b + c: ");
		b.add(c);
		System.out.println(b.toString());
		System.out.print("are a and b equal? ");
		System.out.println(a.compareTo(b));
		System.out.print("b = b - c: ");
		b.subtract(c);
		System.out.print(b.toString() + " ");
		b.reduce();
		System.out.println("( " + b.toString() + " reduced )");

		System.out.println("-- Testing Relations -- ");
		Rational p = new Rational(2, 3);
		Rational q = new Rational(4, 7);
		Rational r = new Rational(2, 21);
		System.out.print("p related with q? ");
		System.out.println(p.compareTo(q));
		System.out.print("q related with p? ");
		System.out.println(q.compareTo(p));
		q.add(r);
		System.out.print("now, q related with p? ");
		System.out.println(q.compareTo(p));
		System.out.print("same as p related with q? ");
		System.out.println(p.compareTo(q));
	}
}
