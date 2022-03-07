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
    arr[s] = arr[b];

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
