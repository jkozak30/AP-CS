// Team Wires: Julia Kozak, Joshua Yagupsky, Abdullah Faruque
// APCS
// HW18 -- CPA-One
// 2021-10-18

/*
DISCO: Integer.toString(<Integer>) can be used to print integers;
       You can use if/else within an if/else statement;
       \n creates a New line within print
QCC:
Team Wires' Latest and Greatest Q2 Response: We know java provides a default constructor because when we try to print the value of an instance variable before the value is set, there is a default printed response (ex. ints printed as 0, and Strings printed as "null")
Team Wires' Latest and Greatest Q3 Response: 
*/

public class BankAccount {
  // instance variables
  public int lastID = 987654321;
  public String name;
  private String password;
  private int PIN;
  private int userID;
  private int bal;
  // Overloaded constructor
  public BankAccount(String pname, String ppassword, int pPIN, int pbal) {
    name = pname;
    password = ppassword;
    PIN = pPIN;
    bal = pbal;
    userID = lastID;
  }
  // Print name, ID, and balance with the input of PIN
  public void printInfo(int pPIN) {
    if (pPIN == PIN) {
      System.out.println("---- ACCOUNT INFO ----\nName: " + name + "\nPassword: " + password + "\nPIN: " + Integer.toString(PIN) + "\nID: " + Integer.toString(userID) + "\nBalance: $" + Integer.toString(bal));
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  // Change password with input of old password, new password, and PIN
  public void setPassword(String oldPass, String newPass, int pPIN) {
    if (pPIN == PIN && oldPass == password) {
      password = newPass;
      System.out.println("Your password has been changed to " + newPass);
    } else {
      System.out.println("PIN or old password was incorrect");
    }
  }
  // Change name with input of PIN
  public void setName(String pname, int pPIN) {
    if (pPIN == PIN) {
      name = pname;
      System.out.println("Your account name has been changed to " + name);
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  // Set PIN with password, old PIN, and new PIN
  public void setPIN(String ppassword, int oldPIN, int newPIN) {
    if (oldPIN == PIN && ppassword == password) {
      PIN = newPIN;
      System.out.println("Your PIN has been changed to " + PIN);
    } else {
      System.out.println("Password or old PIN was incorrect");
    }
  }
  // Deposit into balance with input of PIN
  public void deposit(int deposit, int pPIN) {
    if (pPIN == PIN) {
      bal = bal + deposit;
      System.out.println("Your balance is now " + bal);
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  // Withdrawal from balance with input of PIN
  public void withdraw(int withdrawal, int pPIN) {
    if (pPIN == PIN) {
      if (withdrawal < bal) {
        bal = bal - withdrawal;
        System.out.println("Your balance is now " + bal);
      } else {
	System.out.println("You cannot withdraw more than what is in your account");
      }
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  public static void main(String[] args) {
    // create instance
    BankAccount John = new BankAccount("John", "passw", 1039, 92904120);
    // print Info
    John.printInfo(1033); // error
    John.printInfo(1039); // ok
    // set Password
    John.setPassword("passw", "ok", 1009); // error
    John.setPassword("pas", "ok", 1039); // error
    John.setPassword("passw", "ok", 1039); // ok
    //name change
    John.setName("John Doe", 1033); // error
    John.setName("John Doe", 1039); // ok
    // PIN change
    John.setPIN("passw", 1039, 2049); // error
    John.setPIN("ok", 1033, 2049); // error
    John.setPIN("ok", 1039, 2049); //ok
    // deposit
    John.deposit(2900, 2048); // error
    John.deposit(2900, 2049); // ok
    // withdrawal
    John.withdraw(2900, 2048); // error
    John.withdraw(994584299, 2049); // error
    John.withdraw(2900, 2049); // ok
    // re-print info with new name, PIN, password, balance
    John.printInfo(2049);
  }
}
