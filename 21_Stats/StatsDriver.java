/**
   Team Wires: Julia Kozak, Joshua Yagupsky, Abdullah Faruque
   APCS
   HW21 -- STAtisTically Speaking...
   2021-10-20
 **/

 /**
  DISCO: Math.pow and Math.sqrt return doubles, and Math.round returns a long
  QCC:
 **/

public class StatsDriver {
  public static void main(String[] args){
    System.out.println(Stats.mean(15,15)); //Should be 15
    System.out.println(Stats.mean(10,11)); //Should be 10
    System.out.println(Stats.mean(1500000000,1500000000)); //Should be 1500000000
    System.out.println(Stats.mean(10.0,11.0)); //Should be 10.5
    System.out.println(Stats.max(-2,2)); //Should be 2
    System.out.println(Stats.max(-2147483648,2147483647)); //Should be the bigger one
    System.out.println(Stats.max(10.0,11.0)); //Should be 11.0
    System.out.println(Stats.geoMean(4,9)); //Should be 6
    System.out.println(Stats.geoMean(4.0,9.0)); //Should be 6.0
    System.out.println(Stats.geoMean(-1,1)); //Should give you some sort of error message, since you cannot take the geometric mean of a negative and a positive number
    System.out.println(Stats.geoMean(-1.0,1.0)); //Should still give you an error since one is negative
    System.out.println(Stats.harmonicMean(2.0,6.0)); //Should be 3.0
    System.out.println(Stats.harmonicMean(2.0,5.0,20.0)); //Should be 4.0
  }
}
