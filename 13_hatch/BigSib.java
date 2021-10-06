//Julia Kozak
//APCS
//HW13 -- Where do BigSibs Come From?
//2021-10-07

/* DISCO: Constructor has to have the name of the public class;
QCC:
*/

public class BigSib {
	String helloMsg;
	public BigSib() {
		helloMsg = "Hello";
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

