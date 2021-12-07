// Team Orange Marshmallows: Julia Kozak, Nina Jiang, Diana Akhmedova
// APCS pd08
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07
// Time Spent: 0.5 hrs

/*
DISCO: you can redefine the value of an array variable set it to a new size;
       array elements can be copied to a resized array via for loop;
       use a temporary array to store old values to be copied over;
QCC:   is there a more efficient way of creating a dynamic array?
       is there a way to adapt this to allow different object types to be stored in one array?
*/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = _data.length;
    for (int i=0; i<_size; i++) {
      _data[i] = 0;
    }
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String ans = "[";
    for (int a : _data) {
      ans += a + ",";
    }
    ans = ans.substring(0, ans.length()-1);
    ans += "]";
    return ans;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] copy = new int[_size];
    for (int i=0; i<_size; i++) {
      copy[i] = _data[i];
    }
    _data = new int[_size * 2];
    for (int i=0; i<_size; i++) {
      _data[i] = copy[i];
    }
    _size *= 2;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    if (index >= _data.length || index < 0) {
      System.out.println("Error. Invalid index. Returned 0.");
      return 0;
    }
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    if (index >= _data.length || index < 0) {
      System.out.println("Error. Invalid index. No changes made.");
      return 0;
    }
    int copy = _data[index];
    _data[index] = newVal;
    return copy;
  }


  //main method for testing
  public static void main( String[] args )
  {

      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }

  }//end main()


}//end class
