//Julia Kozak (Flopsy); John Gupta-She (Po); Kevin Cheng
//APCS
//HW14 -- Customize Your Creation
//2021-10-08

/* DISCO: You can have multiple contructors, overloaded ones can take inputs;
QCC:
*/


public class Greet {
	public static void main(String[] args) {
		String greeting;
		BigSib richard = new BigSib();
		BigSib grizz = new BigSib();
		BigSib dotCom = new BigSib();
		BigSib tracy = new BigSib();

		greeting = richard.greet("freshman");
		System.out.println(greeting);
		greeting = tracy.greet("Dr. Spaceman");
		System.out.println(greeting);
		greeting = grizz.greet("Kong Fooey");
		System.out.println(greeting);
		greeting = dotCom.greet("mom");
		System.out.println(greeting);
	}
}
