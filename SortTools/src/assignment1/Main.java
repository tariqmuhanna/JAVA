/*
 * This file is how you might test out your code.  Don't submit this, and don't
 * have a main method in SortTools.java. test
 */

package assignment1;

import java.util.Arrays;

public class Main {
    public static void main(String [] args) {

        // call your test methods here
        int[] x = {5,1,2,3,4};
        boolean result = SortTools.isSorted(x, 5); //etc.
        System.out.println(result);
        int[] y = {1,2,3,4,5};
        System.out.println(SortTools.find(y, 5, 5));
        int[] z = {1,2,4,5};
        z = SortTools.insertGeneral(z, 4, 3);
        System.out.println(Arrays.toString(z));
        int[] a = {1,2,3,4,5,6,8,9,10};
        System.out.println(Arrays.toString(SortTools.insertGeneral(a, a.length, 7)));
        int[] b = {1,2,3,4,5,6,7,8,10};
        System.out.println("insert");
        SortTools.insertInPlace(b,b.length-1,1);

        int[]c = {20,2,98,4,17,6,8,34,10};
        SortTools.insertSort(c ,c.length);
        System.out.println(Arrays.toString(c));
    }
}
