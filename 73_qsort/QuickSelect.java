public class QuickSelect {


    public static void swap(int x, int y, int[] o) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    public static int partition(int arr[], int lo, int hi, int pvtIndex) {
        int pvt = arr[pvtIndex];

        swap(pvtIndex, hi, arr);

        int storIndex = lo;
        for (int i = lo; i < hi - 1; i++) {
            if (arr[i] < pvt) {
                swap(storIndex, i, arr);
                storIndex++;
            }
        }
        swap(hi, storIndex, arr);

        return storIndex;
    }

    public static int ythSmallestHelper(int[] arr, int lo, int hi, int y) {
        //primary base case: 1 element array
        if (lo == hi) {return arr[lo];}

        //partition the array.
        int pos = partition(arr, lo, hi, y-1);

        //other base case: final index of pivot after partition is == to pos of y
        if (pos == y - 1) {return arr[pos];}

        //final pivot index > y pos, yth smallest is at lower partition.
        if (pos > y - 1) {return ythSmallestHelper(arr, lo, pos, y);}

        //final pivot index < y pos, yth smallest is at upper partition.
        return ythSmallestHelper(arr, pos + 1, hi, y);

    }

    public static int ythSmallest(int[] arr, int y) {
        return ythSmallestHelper(arr, 0, arr.length - 1, y);
    }

    public static void main(String[] args) {
        int[] a1 = {1,7,3,12,5};

        System.out.println(ythSmallest(a1, 1)); // best case
        System.out.println(ythSmallest(a1, 4)); // worst case.

    }
}
