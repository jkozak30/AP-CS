public class BankAccount {
  // instance variables
  public int lastID = 1000;
  public String name;
  private String password;
  private int PIN;
  private int userID;
  private int bal;
  public void BankAccount(String pname, String ppassword, int pPIN, int pbal) {
    name = pname;
    password = ppassword;
    PIN = pPIN;
    bal = pbal;
    userID = lastID;
    lastID = lastID + 1;
  }
  public void printInfo(int pPIN) {
    if (pPIN == PIN) {
      System.out.println("INFO:\nName: " + name + "\nID: " + Integer.toString(userID) + "\nBalance: $" + Integer.toString(bal));
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  public void setPassword(String oldPass, String newPass, int pPIN) {
    if (pPIN == PIN && oldPass == password) {
      password = newPass;
      System.out.println("Your password has been changed to " + newPass);
    } else {
      System.out.println("PIN or old password was incorrect");
    }
  }
  public void setName(String pname, int pPIN) {
    if (pPIN == PIN) {
      name = pname;
      System.out.println("Your account name has been changed to " + name);
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  public void setPIN(String ppassword, int oldPIN, int newPIN) {
    if (oldPIN == PIN && ppassword == password) {
      PIN = newPIN;
      System.out.println("Your PIN has been changed to " + PIN);
    } else {
      System.out.println("Password or old PIN was incorrect");
    }
  }
  public void deposit(int deposit, int pPIN) {
    if (pPIN == PIN) {
      bal = bal + deposit;
      System.out.println("Your balance is now " + bal);
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  public void withdraw(int withdrawal, int pPIN) {
    if (pPIN == PIN) {
      bal = bal - withdrawal;
      System.out.println("Your balance is now " + bal);
    } else {
      System.out.println("PIN was incorrect");
    }
  }
  public static void main(String[] args) {
    // create instance
    BankAccount John = new BankAccount();
    John.BankAccount("John", "passw", 1039, 92904120);
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
    John.setPIN("ok", 1039, 2049); //ok
    // deposit
    John.deposit(2900, 2048); // error
    John.deposit(2900, 2049); // ok
    // withdrawal
    John.withdraw(2900, 2048); // error
    John.withdraw(2900, 2049); // ok
    //test things
  }
}
