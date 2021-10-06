//Julia Kozak
//APCS
//HW13 -- Where do BigSibs Come From?
//2021-10-07

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
