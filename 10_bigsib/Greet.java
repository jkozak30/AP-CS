//Dunking Ducks: Julia Kozak (Flopsy); Jason Zhou (Tiggy); Daniel Jung (Ralph)
//APCS
//HW10 -- Refactor Big Sib One
//2021-10-05

/* DISCOVERIES: System.out.println() can print the output of a different method; public static void cannot return values
UNRESOLVED QUESTIONS: 
*/

public class Greet {
    public static void main( String[] args ){
        System.out.println( BigSib.greet("Crosby") );
        System.out.println( BigSib.greet("Stills") );
        System.out.println( BigSib.greet("Nash") );
    }
}
