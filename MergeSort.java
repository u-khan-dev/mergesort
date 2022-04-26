/*
MERGE(A, left, middle, right)
   s1 ← middle - left + 1
   s2 ← right - middle

   create arrays L[s1] and R[s2]

   for i ← 0 to s1 - 1
	  do L[i] ← A[left + i]

   for j ← 0 to s2 - 1
	  do R[j] ← A[middle + 1 + j]

   i ← 0
   j ← 0

   k ← left

   while i < s1 and j < s2
        do if L[i] <= R[j]
		 then A[k] ← L[i]
		       i ← i + 1
            else A[k] ← R[j]
		       j ← j + 1

        k ← k + 1

   while i < s1
 	  A[k] ← L[i]
	  i ← i + 1
	  k ← k + 1

   while j < s2
	  A[k] ← R[j]
	  j ← j + 1
	  k ← k + 1
*/


/*
MERGESORT(A, L, R)
    do if L < R
	   then M = L + (R - L) / 2
	 	MERGESORT(A, L, M)
		MERGESORT(A, M + 1, R)
		MERGE(A, L, M, R)
 */

import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {

    static void merge(int arr[], int left, int middle, int right) {
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = left;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < leftArraySize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();

        int[] arr = {10, 1, 0, 3, 4, 20, 11, 100, 2, 5, 7, 14, 10};
	    
	    /*
	    	Use code below (uncomment it) to test sort a billion-integer array.
		Remember to comment out arr[] above and the printArray calls below before doing this!
	    */

//         int[] arr = new int[1000000000];

//         int length = arr.length;

//         for (int i = 0; i < length; i++) {
//             arr[i] = ThreadLocalRandom.current().nextInt(0, 1000000000 + 1);
//         }

       System.out.println("\nInput array");
       printArray(arr);

//         long startTime = System.nanoTime();
         ms.mergeSort(arr, 0, arr.length - 1);
//         long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1000000000;

       System.out.println("\n\nSorted array");
       printArray(arr);

        System.out.println("\nDuration\n" + duration);
    }

}
