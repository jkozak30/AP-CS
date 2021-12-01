public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational() {
		numerator = 0;
		denominator = 1;
	}
	
	public Rational(int num, int den) {
		numerator = num;
		if (den != 0) {
			denominator = den;
		} else {
			this.Rational();
		}
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public float floatValue() {
		return (float)numerator/denominator;
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
		System.out.println(a.toString());
	}
}
