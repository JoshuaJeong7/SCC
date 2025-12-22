public class TimeLab {
	final int N = 100000;
        
    int[] arr = new int[N];
    
    public void resetArr(int n) {
		arr = new int[n];
		for (int i = 0; i < n; i++) 
			{ arr[i] = (int)(Math.random() * N); }
	}
	public static void main(String[] args) {
		TimeLab tL = new TimeLab();
        tL.timeIteratives();
		tL.timeRecursives();
		
    }
    
	public void timeSortGeneric(String msg, IndivSorter sortMethod, int n) {
		resetArr(n);
		System.out.println("\n\n{{ " + msg + " }}");
		System.out.println("Array size: " + n + "\n");
		long start = System.nanoTime();
        
		sortMethod.thisSort(arr);

        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;
		
        System.out.println("Amount of seconds to run: " + time);
        if (!SortHelper.isSorted(arr)) System.out.println("ERROR: Method did not sort!");
	}
    
    public void timeIteratives() {
		IndivSorter sIterative = new SelectionSortIterative();
		IndivSorter iIterative = new InsertionSortIterative();
		IndivSorter mIterative = new MergeSortIterative();

		System.out.println(">>>>> ITERATIVE RUNTIMES: \n");
		timeSortGeneric("SELECTION SORT", sIterative, N);
		timeSortGeneric("INSERTION SORT", iIterative, N);
		timeSortGeneric("MERGE SORT", mIterative, N);
		System.out.println("\n\n———————————————————————————————————————————————————\n");
	}

	public void timeRecursives() {
		IndivSorter sRecursive = new SelectionSortRecursive();
		IndivSorter iRecursive = new InsertionSortRecursive();
		IndivSorter mRecursive = new MergeSortRecursive();

		System.out.println(">>>>> RECURSIVE RUNTIMES: \n");
		timeSortGeneric("SELECTION SORT", sRecursive, Math.min(N/10, 35000));
		timeSortGeneric("INSERTION SORT", iRecursive, Math.min(N/10, 35000));
		timeSortGeneric("MERGE SORT", mRecursive, Math.min(N/10, 100000));
		System.out.println("\n\n———————————————————————————————————————————————————\n");
	}
}

class SelectionSortRecursive extends IndivSorter {
    public void thisSort(int[] arr) {
		int n = arr.length;
		selectionSort(arr, n);
    }

	public void selectionSort(int[] arr, int n) {
		if (n <= 1) return;
		int indexOfBiggest = 0;
		int a = 0;
		for (a = 0; a < n; a++) {
			if (arr[a] > arr[indexOfBiggest]) {
			indexOfBiggest = a;
			}
		}
		SortHelper.swap(arr, indexOfBiggest, a - 1);
		selectionSort(arr, n - 1);
	}
}

class InsertionSortRecursive extends IndivSorter {
    public void thisSort(int[] arr) {
		int n = arr.length;
		insertionSort(arr, 1, n);
    }

	public void insertionSort(int[] arr, int i, int n) {
		if (i >= n) return;
		int temp = arr[i];
		int j = i;
		while (j > 0 && arr[j - 1] >= temp) {
			arr[j] = arr[j - 1];
			j--;
		}
		arr[j] = temp;
		insertionSort(arr, i + 1, n);
	}
}

class MergeSortIterative extends IndivSorter {
    public void thisSort(int[] arr) {
		int n = arr.length;
		
		/*
		 *  If you're curious, this iterative approach to merge sort reverses
		 *  the steps of recursive merge sort. 
		 * 
		 *  In recursion, we start with one continuous array, split all subarrays, 
		 *  then sequentially merge them back together.
		 * 
		 *  In this iterative version, we start with several mini arrays and
		 *  merge the adjacent ones. Then, we double the size of the subarrays we
		 *  merge, and continually merge all arrays until we reach the continuous
		 *  array that is now fully sorted.
		 * 
		 *  We have to account for if the subarray sizes will not be even,
		 *  however. To do this, we will just make the last subarray as big
		 *  as there is space left in the array (which may mean the left subarray
		 *  has 8 elements while the right subarray only has 1 or 2).
		 */
		for (int subArrSize = 1; subArrSize < n; subArrSize *= 2) {
			
			/*
			 *  To understand this, a visual indicator is helpful:
			 * 
			 * 
			 *  (subArrSize * 2)
			 *  <--------->
			 *  +————+————+————+————+————+————+————+————+————+————+————+
			 *  | 1  | 8  | 4  | 6  | 2  | 3  | 7  | 5  | 9  | 0  | 10 |
			 *  +————+————+————+————+————+————+————+————+————+————+————+
			 *  <---->
			 *  (leftFrom -> leftTo)
			 * 
			 * We are adding leftFrom by subArrSize * 2 because that represents
			 * the two sections (the left section and the right section)
			 * that we will merge together.
			 */
			for (int leftFrom = 0; leftFrom < n - 1; leftFrom += subArrSize * 2) {
				
				//This is mostly math stuff, I recommend tracing it out with small examples.
				int leftTo = Math.min(leftFrom + subArrSize, n);
				int rightFrom = leftTo;
				int rightTo = Math.min(leftFrom + subArrSize * 2, n);
				
				SortHelper.mergeIterative(arr, leftFrom, leftTo, rightFrom, rightTo);
			}
		}
	}
}