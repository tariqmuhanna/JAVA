// SortTools.java
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Tariq Muhanna
 * tim278
 * 16345
 * Fall 2018
 * Slip days used: 0
 */

package assignment1;

import java.util.Arrays;

public class SortTools {
    /**
     * This method tests to see if the given array is sorted.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @return true if array is sorted
     */
    public static boolean isSorted(int[] x, int n) {
        // stub only, you write this!
        // TODO: complete it
        if (n == 0)
            return false;

        if (n == 1)
            return true;

        // if current # is greater than previous #, return false
        if (x[n-2] >= x[n-1])
            return false;

        return isSorted(x, (n-1));
    }


    public static int binarySearch(int[] x, int l, int r, int v) {
        if(r>=l){
            int mid = l + (r - l)/2;

            if(x[mid] == v)
                return mid;

            if(x[mid] > v)
                return binarySearch(x, l, mid-1, v);

            return binarySearch(x,mid+1, r, v);
        }
        return -1;
    }

    /**
     * This method returns the index of value v within array x.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @param v is the value to be searched for within x
     * @return index of v if v is contained within x. -1 if v is not contained within x
     */
    public static int find(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
        if (!isSorted(x,n))
            System.exit(0);

        if (n == 0)
            return -1;

        return binarySearch(x, 0, n-1, v);
    }

    /**
     * This method returns a newly created array containing the first n elements of x, and v.
     * @param x is the array
     * @param n is the number of elements to be copied from x
     * @param v is the value to be added to the new array
     * @return a new array containing the first n elements of x, and v
     */
    public static int[] insertGeneral(int[] x, int n, int v){
        // stub only, you write this!
        // TODO: complete it
        if (!isSorted(x,n))
            System.exit(0);

        int index = find(x, n, v);
        if(!(index == -1)) {
            return x;
        }
        int y[] = new int[n+1];

        int j = 0;
        int i;
        int complete = 0;

        for(i=0; i < (n); i++) {
            if (v < x[i] & complete == 0) {
                y[j++] = v;
                i--;
                complete = 1;
            }
            else {

                y[j++] = x[i];
            }
        }

        if (i == n & v > x[i-1] & complete == 0) {
            y[j++] = v;
        }

        x = null;
        return y;
    }

    /**
     * This method inserts a value into the array and ensures it's still sorted
     * @param x is the array
     * @param n is the number of elements in the array
     * @param v is the value to be added
     * @return n if v is already in x, otherwise returns n+1
     */
    public static int insertInPlace(int[] x, int n, int v){
        // stub only, you write this!
        // TODO: complete it
        if (!isSorted(x,n))
            System.exit(0);

        int index = find(x, n, v);
        if(!(index == -1)) {
            return n;
        }

        int prev = 0;
        int curr = 0;
        int i;
        boolean insertedFlag = false;
        for (i=0; i<n+1; i++){
            if (i == n & !insertedFlag){
                x[i] = v;
            }
            else if (insertedFlag){
                curr = x[i];
                x[i] = prev;
                prev = curr;
            }
            else if(v < x[i] & !insertedFlag){
                prev = x[i];
                x[i] = v;
                insertedFlag = true;
            }
        }
        System.out.println(Arrays.toString(x));
        return n+1;

    }

    /**
     * This method sorts a given array using insertion sort
     * @param x is the array to be sorted
     * @param n is the number of elements of the array to be sorted
     */
    public static void insertSort(int[] x, int n){
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
            if (x[j] < x[min])
                min = j;

            int temp = x[i];
            x[i] = x[min];
            x[min] = temp;
        }
    }
}
