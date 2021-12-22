public class Driver {
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
