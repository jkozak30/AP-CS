//Julia Kozak
//APCS
//HW13 -- Where do BigSibs Come From?
//2021-10-07

/* DISCOVERIES:
UNRESOLVED QUESTIONS:
*/
public class Greet {
  public static void main( String[] args ) {
    String greeting1, greeting2, greeting3, greeting4;

    BigSib richard = new BigSib();

    greeting1 = richard.greet("freshman");
    System.out.println(greeting1);

    BigSib robert = new BigSib();
    robert.setHelloMsg("Salutations");

    greeting2 = robert.greet("Dr. Spaceman");
    System.out.println(greeting2);

    BigSib ruby = new BigSib();

    greeting3 = ruby.greet("Kong Fooey");
    System.out.println(greeting3);

    BigSib roy = new BigSib();
    roy.setHelloMsg("Sup");

    greeting4 = roy.greet("mom");
    System.out.println(greeting4);
  } //end main()
} //end Greet
