public class SortHelper {

	public static void swap(int[] arr, int indexA, int indexB) {
		int temp = arr[indexA];
		arr[indexA] = arr[indexB];
		arr[indexB] = temp;
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i+1]) return false;
		}
		return true;
	}
	
	public static int[] copyArray(int[] orig, int from, int to) {
        int[] copyArr = new int[to - from];
        int count = 0;
        for (int i = from; i < to; i++) {
            copyArr[count] = orig[i];
            count++;
        }
        return copyArr;
    }
	
	public static void mergeIterative(int[] orig, int lFrom, int lTo, int rFrom, int rTo) {
		
		int lLen = lTo - lFrom;
		int rLen = rTo - rFrom;
		
		int[] newL = new int[lLen];
		int[] newR = new int[rLen];
		
		for (int a = 0; a < lLen; a++) { 
			newL[a] = orig[lFrom + a];
		}
		for (int b = 0; b < rLen; b++) {
			newR[b] = orig[rFrom + b];
		}
		
		int ptr = lFrom;
		int l = 0; int r = 0;
		while (l < lLen && r < rLen) {
			if (newL[l] <= newR[r]) {
				orig[ptr] = newL[l];
				l++;
			}
			else {
				orig[ptr] = newR[r];
				r++;
			}
			ptr++;
		}
		
		while (l < lLen) {
			orig[ptr] = newL[l];
			l++;
			ptr++;
		}
		
		while (r < rLen) {
			orig[ptr] = newR[r];
			r++;
			ptr++;
		}
	}
}
