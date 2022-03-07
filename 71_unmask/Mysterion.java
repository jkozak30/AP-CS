// Great, Nice Jingles: Julia Kozak, Gloria Lee, Nafiz Labib (Flopsy, Flounder, Martha)
// APCS
// HW71 -- Whut Dis.
// 2022-03-08
// time spent: 0.5hrs

/*
DISCO:
 - Step-by-step tracing is a good way of tracking steps.
 - 

QCC:
 - 

q0: What does it do?
 - This program partitions the set into two sets of terms based on the value of index c, and in a given range of indices [a, b]. It checks if each value in that range is less than arr[c], moves it to the front if so, then swaps the value of arr[c] to the end of those.

q1: What is its Big-Oh runtime?
 - O(n), because it iterates through each value in the range [a, b] and does one action (swap/not swap) in each of those iterations.

*/

public class Mysterion {

  public static int[] mysterion(int[] arr, int a, int b, int c) {
    int v = arr[c];
    //
    arr[c] = arr[b];
    arr[b] = v;
    //
    int s=a;
    for (int i=a; i<b; i++) {
      if (arr[i] < v) {
        int temp = arr[s];
        arr[s] = arr[i];
        arr[i] = temp;
        s++;
      }
    }
    //
    int temp = arr[b];
    arr[b] = arr[s];
    arr[s] = temp;

    return arr;
  }





  public static void main(String[] args) {
    int[] test = {3, 61, 10, 2, 5};
    int[] result = mysterion(test, 0, 4, 2);
    for (int i : result) {
      System.out.print(i + ", ");
    }
    System.out.println();
  }

}
