//Julia Kozak
//APCS
//HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
//2021-10-06

/* DISCO: "static" won't work with instance variables;
QCC:
*/

public class BigSib {
	String helloMsg;
	public String setHelloMsg(String s) {
		helloMsg = s;
		return helloMsg;
	}
	public String greet(String s) {
		String greeting = helloMsg;
		String message = (greeting + " " + s);
		return message;
	}
}

