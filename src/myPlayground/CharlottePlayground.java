package myPlayground;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class CharlottePlayground {
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void selection_sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);

			System.out.println("current status");
			for (int x = 0; x < a.length; x++) {
				System.out.println(a[x]);
			}
			System.out.println("_______");
		}
	}

	public static void insertion_sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
			}
			System.out.println("current status");
			for (int x = 0; x < a.length; x++) {
				System.out.println(a[x]);
			}
			System.out.println("_______");
		}
	}

	private static void merge_sort_helper(Comparable[] a, Comparable[] aux, int lo, int hi) {

		if (hi <= lo) // Base case, return
			return;
		int mid = lo + (hi - lo) / 2; // Computes midpoint
		merge_sort_helper(a, aux, lo, mid); // Sort the first half
		merge_sort_helper(a, aux, mid + 1, hi); // Sort the second half
		merge(a, aux, lo, mid, hi); // Merge the 2 halves
		System.out.println("current status");
		for (int x = 0; x < a.length; x++) {
			System.out.println(a[x]);
		}
		System.out.println("_______");
	}

	public static void merge_sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length]; // Create aux array
		merge_sort_helper(a, aux, 0, a.length - 1); // Recursively call sort
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) // copy to aux array
			aux[k] = a[k];
		int i = lo, j = mid + 1;
		// lo and mid+1 are the start of the 2 sorted halves
		for (int k = lo; k <= hi; k++) {
			if (i > mid) // ran out of elements in the left subarray
				a[k] = aux[j++];
			else if (j > hi) // ran out of elements in the right subarray
				a[k] = aux[i++];
			else if (less(aux[j], aux[i])) // Compares left and right subarray
				a[k] = aux[j++]; // right element smaller
			else
				a[k] = aux[i++]; // left element smaller
		}
	}
	
//	private static void quick_sort(Comparable[] a, int lo, int hi) {
//		 if (hi <= lo) return;
//		 int j = partition(a, lo, hi);
//		 quick_sort(a, lo, j-1);
//		 quick_sort(a, j+1, hi);
//		 }
	
	

	public static void main(String[] args) {
		Integer[] selectionList = { 35, 3, 7, 2, 14 };
		Integer[] insertionList = { 35, 4, 1, 100, 5 };
		Integer[] mergeList = { 28, 0, 15, 10, 52 };
		
		// selection_sort(selectionList);
//		insertion_sort(insertionList);
		merge_sort(mergeList);
		//heap_sort(mergeList);
//		for (int i = 0; i < myList.length; i++) {
//			System.out.println(myList[i]);
//		}
	}

}
