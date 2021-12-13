// Clyde "Thluffy" Sinclair
// APCS pd00
// Lab02
// 2021-12-13

/**********************************************
 * class OrderedArrayList
 * wrapper class for ArrayList
 * maintains invariant that elements are ordered (ascending)
 * (SKELETON)
 **********************************************/


import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;

  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
  _data = new ArrayList<>();
  for (int i=0; i<23; i++) {
  	_data.add(i);
  }
  }

  public String toString()
  {
  String ans = "{ ";
  for (int i=0; i<_data.size(); i++) {
  	ans += _data.get(i) + ", ";
  }
  ans = ans.substring(0, ans.length()-2);
  ans += " }";
  return ans;
  
  }

  public Integer remove( int i )
  {
  int temp = _data.get(i);
  _data.remove(i);
  return temp;
  }

  public int size()
  {
  return _data.size();
  }

  public Integer get( int i )
  {
  return _data.get(i);
  }

  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  public void addLinear(Integer newVal)
  {
  for (int i=0; i<_data.size()-1; i++) {
  	if(_data.get(i) > newVal) {
  		_data.add(i, newVal);
  		break;
  	}
  }
  if (_data.get(_data.size()-1) < newVal) {
  	_data.add(newVal);
  }
  }

  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  public void addBinary(Integer newVal)
  {
  int middle = _data.size()/2;
  int increment = _data.size()/2;
  while( middle > 0 && middle < _data.size()-1) {
  	if(_data.get(middle) < newVal && _data.get(middle+1) > newVal) {
  		_data.add(middle, newVal);
  		break;
  	}  else if (_data.get(middle) > newVal){
		increment = (increment +1)/2;
  		middle -= increment;
  	} else {
		increment = (increment +1)/2;
  		middle += increment;
  	}
  }
  if (middle <= 0) {
  	_data.add(0, newVal);
  } else {
  	_data.add(newVal);
  }
  }	

  // main method solely for testing purposes
  public static void main( String[] args )
  {


    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    // testing binary search
    Franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ ) 
      Franz.addBinary( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

  }//end main()

}//end class OrderedArrayList

