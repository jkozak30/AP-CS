import java.util.*;

public class MySorts {
  public static void bubbleSort( ArrayList<Comparable> data ) {
    for(int i = 0; i < data.size()-1; i++) {

    	for(int j = data.size() - 1; j > i; j--){
    		if((data.get(j)).compareTo(data.get(j-1)) < 0) {
          Comparable temp = data.get(j);
          data.set(j, data.get(j - 1));
          data.set(j-1, temp);
    		}
    	}
    }
  }

  public static void selectionSort( ArrayList<Comparable> data ) {
    int minPos;

    for(int i=0; i<data.size()-1; i++) {
      minPos = i;

      for(int j=i+1; j<data.size(); j++) {
        if ((data.get(j)).compareTo(data.get(minPos)) < 0) {
          minPos = j;
        }
      }
      Comparable temp = data.get(i);
      data.set(i, data.get(minPos));
      data.set(minPos, temp);
    }
  }

  public static void insertionSort( ArrayList<Comparable> data ) {

    for( int i=1; i<data.size(); i++ ) {
      for( int j=i; j>0; j-- ) {

        if ((data.get(j)).compareTo(data.get(j-1)) < 0 ) {
          Comparable temp = data.get(j);
          data.set(j, data.get(j-1));
          data.set(j-1, temp);
        } else {
          break;
        }

      }
    }
  }
}
