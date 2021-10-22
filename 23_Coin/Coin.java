/*
* Creative Name - Julia Kozak, Neil Lin (Flopsy, Hatch)
* APCS
* HW23 -- What Does Equality Look Like?
* 2021-10-22
*
* DISCO: Math.random() generates a random double from 0.0 to 1.0
*
*
* QCC: what does .toString() do, or how were we supposed to use it?
*
*/

public class Coin {
  //attributes aka instance vars
  private double value;
  private String upFace;
  private String name;
  private int flipCtr, headsCtr, tailsCtr;
  private double bias;


  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
  flipCtr = 0;
  headsCtr = 0;
  tailsCtr = 0;
  bias = 0.5;
  name = "null";
  upFace = "heads";
  assignValue(name);
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
  if (s == "penny" || s == "nickel" || s == "dime" || s == "quarter" || s == "half dollar" || s == "dollar") {
  	name = s;
  } else {
  	System.out.println("Invalid coin.");
  }
  upFace = "heads";
  flipCtr = 0;
  headsCtr = 0;
  tailsCtr = 0;
  bias = 0.5;
  assignValue(name);
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
  	if (s == "penny" || s == "nickel" || s == "dime" || s == "quarter" || s == "half dollar" || s == "dollar") {
  	name = s;
  } else {
  	name = "null";
  }
  upFace = nowFace;
  flipCtr = 0;
  headsCtr = 0;
  tailsCtr = 0;
  bias = 0.5;
  assignValue(name);
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {
  return upFace;
  }

  public int getFlipCtr() {
  return flipCtr;
  }

  public double getValue() {
  return value;
  }

  public int getHeadsCtr() {
  return headsCtr;
  }

  public int getTailsCtr() {
  return tailsCtr;
  }

  public double getBias() {
    return bias;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
  if (s == "penny") {
  value = 1;
  }
  if (s == "nickel") {
  value = 5;
  }
  if (s == "dime") {
  value = 10;
  }
  if (s == "quarter") {
  value = 25;
  }
  if (s == "half dollar") {
  value = 50;
  }
  if (s == "dollar") {
  value = 100;
  }
  return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
  if (s == "heads" || s == "tails"){
  	upFace = s;
  	flipCtr = 0;
  	headsCtr = 0;
  	tailsCtr = 0;
  	if (d <= 1.0 && d >= 0.0){
  		bias = d;
  	}
  }
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    flipCtr += 1;
    double flip = Math.random();
    boolean isHeads = (flip <= bias);
    if (isHeads == true) {
      upFace = "heads";
      headsCtr += 1;
    } else {
      upFace = "tails";
      tailsCtr += 1;
    }
  	return upFace;
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
	if (upFace == other.upFace) {
    return true;
  } else {
    return false;
  }
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
	return name + " -- " + upFace;
  }

}//end class
