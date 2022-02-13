import java.util.*;
import java.io.*;

public class Hangman {

  static String[] setGuess;
  static String guess;
  static String display;
  static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static boolean win = false;

  static void setup() throws Exception{
    setGuess = new String[50];
    Scanner s = new Scanner(new File("songs.txt"));
    for (int i=0; s.hasNext(); i++) {
      try {
        setGuess[i] = s.nextLine();
      } catch (Exception e) {}
    }
    setRandomGuess();
    display = guess;
    for (int i=0; i<display.length()-1; i++) {
      if (letters.toLowerCase().indexOf(display.substring(i, i+1).toLowerCase()) > -1) {
        display = display.substring(0, i) + "#" + display.substring(i+1);
      }
    }
  }

  static void setRandomGuess() {
    int index = (int)(Math.random() * 50);
    guess = setGuess[index];
  }

  static void updateDisplayChar(String s) {
    for (int i=0; i<display.length()-1; i++) {
      if (guess.toLowerCase().substring(i, i+1).equals(s)) {
        display = display.substring(0, i) + guess.substring(i, i+1) + display.substring(i+1);
      }
    }
  }

  static boolean checkInput(String s) {
    if (s.length() == 1 || s.length() == display.length()-1) {
      return true;
    } else {
      return false;
    }
  }

  static void checkWin(String s) {
    if (s.toLowerCase().equals(guess.toLowerCase().substring(0, guess.length()-1))) {
      win = true;
    }
  }


  public static void main(String[] args) throws Exception{
    Scanner input = new Scanner(System.in);
    String in;
    setup();
    System.out.println();
    System.out.println("welcome to hangman");
    System.out.println("your phrase is something of the form Song - Artist");
    System.out.println("you can either guess or reveal a single letter");
    System.out.println("your inputs are not case sensitive");
    System.out.println("you have 12 guesses have fun");
    System.out.println();

    int i=1;
    while (win == false && i<13) {
      System.out.println(display.substring(0, display.length()-1));
      System.out.print("letter or guess #" + i + ": ");
      in = input.nextLine();
      boolean check = checkInput(in);
      System.out.println();
      if (check && in.length() == 1) {
        updateDisplayChar(in.toLowerCase());
        i++;
      } else if (check) {
        checkWin(in);
        i++;
      } else {
        System.out.println("not a valid guess");
      }
    }

    System.out.println(guess.substring(0, guess.length()-1));
    if (win == true) {
      System.out.println("YOUWON");
    } else {
      System.out.println("YOUDIDNTWIN");
    }
  }
}
