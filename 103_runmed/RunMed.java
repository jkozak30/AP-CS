// Rin-Sensei: Julia Kozak, Rin Fukuoka, John Gupta-She
// APCS pd08
// HW103 -- Erica’s Friends, Hugo, and The One in the Middle
// 2022-05-19
// time spent: 0.7 hrs

/** 
 * DISCO:
 * - We can always maintain that the two halves are equal size, or
 *   the lower is one greater in size.
 * 
 * QCC:
 * - Should a median average the middle elements for an even number
 *   of elements? Or take the lower index (like integer division)?
 * - How do you use this to find the min/max of the whole set?
 * 
 * ALGO:
 * 1. Initialize min/max heaps to store your upper half and lower 
 *    half, respectively.
 * 2. When adding, check if the new value is less than your current 
 *    median (the max of the lower maxheap). If not, add it to the 
 *    upper half, and if so, add it to lower.
 * 3. To ensure balance is maintained, check if your upper half is
 *    greater than your lower half, or your lower half is more than 
 *    one greater than your upper half. If so, move the root element 
 *    accordingly.
 * 4. When getting the median, return the largest value (aka root) in
 *    your maxheap.
*/

public class RunMed {
    ALHeapMax lower;
    ALHeapMin upper;

    public RunMed() {
        lower = new ALHeapMax();
        upper = new ALHeapMin();
    }

    public Integer getMedian() {
        if (lower.isEmpty() && upper.isEmpty()) return null;
        return lower.peekMax(); //assuming either equal, or lower half is greater size
        //also integer division stuff median is always there
    }

    public void add(Integer newVal) {
        if (lower.isEmpty() || lower.peekMax() < newVal) upper.add(newVal);
        else lower.add(newVal);
        if (upper.size() > lower.size()) lower.add(upper.removeMin());
        else if (lower.size() == upper.size()+2) upper.add(lower.removeMax());
    }

    public static void main(String[] args) {
        RunMed ito = new RunMed();
        ito.add(10);
        System.out.println(ito.getMedian());
        ito.add(1);
        System.out.println(ito.getMedian());
        ito.add(2);
        System.out.println(ito.getMedian());
        ito.add(7);
        System.out.println(ito.getMedian());
        ito.add(3);
        System.out.println(ito.getMedian());
        ito.add(8);
        System.out.println(ito.getMedian());
        ito.add(9);
        System.out.println(ito.getMedian());
        ito.add(0);
        System.out.println(ito.getMedian());
        ito.add(-1);
        System.out.println(ito.getMedian());

    }
}