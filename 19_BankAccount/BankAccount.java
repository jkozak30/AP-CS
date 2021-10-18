// Team Wires: Julia Kozak, Joshua Yagupsky, Abdullah Faruque
// APCS
// HW19 -- Mo Money Mo Problems ...MORE AWESOME
// 2021-10-19

/*
DISCO: you can use if/else statements to check if an input matches with an instance variable value;
       use (short)<number> (long)<number> etc. to specify that an integer value is a short;
QCC:
*/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
    if ( newPin >= 1000 && newPin <= 9998 ) {
      pin = newPin;
    } else {
      pin = 9999;
      System.out.println("Invalid 4-digit pin. Your new pin is 9999.");
    }
    return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    if ( newAcctNum >= 100000000 && newAcctNum <= 999999998 ) {
      acctNum = newAcctNum;
    } else {
      acctNum = 999999999;
      System.out.println("Invalid 9-digit account number. Your new account number is 999999999.");
    }
    return oldAcctNum;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public boolean withdraw( double withdrawAmount ) {
    if ( withdrawAmount < balance ) {
      balance = balance - withdrawAmount;
      return true;
    } else {
      System.out.println("You cannot withdraw more than what is in your account.");
      return false;
    }
  }

  public boolean authenticate( int nAcctNum, String nPasswd) {
    if ( nAcctNum == acctNum && nPasswd == passwd) {
      return true;
    } else {
      return false;
    }
  }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args ) {
    BankAccount ba = new BankAccount();
    ba.setName("Bob Dole");
    ba.setPasswd("password1");
    ba.setPin((short)11111); //error msg
    System.out.println(ba.toString()); //info with pin 9999
    ba.setPin((short)1234);
    ba.setAcctNum(1192837432); //error msg
    System.out.println(ba.toString()); //info with account number 999999999
    ba.setAcctNum(123456789);
    ba.setBalance(100.0);
    ba.deposit(200.0);
    System.out.println(ba.toString()); //info printed, with new balance
    System.out.println(ba.withdraw(1000.0)); //error msg, prints false
    System.out.println(ba.withdraw(100.0)); //prints true
    System.out.println(ba.toString()); //info printed, with new balance
    System.out.println(ba.authenticate(123456789, "password1")); //true
    System.out.println(ba.authenticate(123456789, "password2")); //false
    System.out.println(ba.authenticate(123456788, "password1")); //false
  }//end main()

}//end class BankAccount
