//Julia Kozak (Flopsy); John Gupta-She (Po); Kevin Cheng
//APCS
//HW14 -- Customize Your Creation
//2021-10-08

/* DISCO: You can have multiple contructors, overloaded ones can take inputs;
QCC:
*/

public class BigSib {
	String helloMsg;
	public BigSib() {
		helloMsg = "Hello";
	}
	public BigSib(String s) {
		helloMsg = s;
	}
	public String setHelloMsg(String s) {
		helloMsg = s;
		return helloMsg;
	}
	public String greet(String s) {
		String message = (helloMsg + " " + s);
		return message;
	}
}
