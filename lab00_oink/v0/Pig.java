/***
 * Julia Kozak, Rin Fukuoka
 * APCS
 * L00 -- Etterbay Odingcay Oughthray Ollaborationcay
 * 2021-11-10
 * time spent: .5hrs
 *
 * class Pig
 * a Pig Latin translator
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 ***/


public class Pig {

  //static vars
  private static final String VOWELS = "aeiou";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!?";

  //checks for specific letter
  public static boolean hasA( String w, String letter ) {
    return w.indexOf(letter) != -1;
  }//end hasA()

  //checks if specific letter is a vowel
  public static boolean isAVowel( String letter ) {
    return VOWELS.indexOf( letter ) != -1;
  }

  //how many vowels in word
  public static int countVowels( String w ) {
    return allVowels(w).length();
  }

  //checks if word has any vowel
  public static boolean hasAVowel( String w ) {
    return w.indexOf(w) >= 0;
  }

  //returns all vowels of a word in a String
  public static String allVowels( String w ) {
    String ans = ""; //init return String
    for( int i = 0; i < w.length(); i++ ) {
      if ( isAVowel( w.substring(i,i+1) ) )
        ans += w.substring( i, i+1 ); //grow the return String
    }
    return ans;
  }

  //finds first vowel in String of allVowels
  public static String firstVowel( String w ) {
    String ans = "";
    if ( hasAVowel(w) )
      ans = allVowels(w).substring(0,1);
    return ans;
  }

  //checks if first letter is vowel
  public static boolean beginsWithVowel( String w ) {
    return isAVowel( w.substring(0,1) );
  }

  //creates word (v0)
  public static String engToPig( String w ) {
    String ans = "";
    if ( beginsWithVowel(w) )
      ans = w + "way";
    else {
      int vPos = w.indexOf( firstVowel(w) );
      ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }
    return ans;
  }

  public static void main( String[] args ) {
    for( String word : args ) {
      System.out.println( "allVowels \t" + allVowels(word) );
      System.out.println( "firstVowels \t" + firstVowel(word) );
      System.out.println( "countVowels \t" + countVowels(word) );
      System.out.println( "engToPig \t" + engToPig(word) );
      System.out.println( "---------------------" );
    }

  }//end main()

}//end class Pig
