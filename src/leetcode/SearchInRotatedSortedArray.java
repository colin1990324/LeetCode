package leetcode;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		int[] B = { 1 };
		int[] C = { 1, 3 };
		int[] D = { 3, 5, 1 };
		int[] E={1,1,3,1};
		int[] F={2,2,0,2};
		int[] G={2,2,2,0,0,1};
		System.out.println("A should be 2, result=" + search(A, 6));
		System.out.println("B should be 0, result=" + search(B, 1));
		System.out.println("C should be 0, result=" + search(C, 1));
		System.out.println("C should be 1, result=" + search(C, 3));
		System.out.println("C should be -1, result=" + search(C, 0));
		System.out.println("D should be 2, result=" + search(D, 1));
		System.out.println("F should be true, result=" + searchII(F, 0));
		System.out.println("G should be true, result=" + searchII(G, 0));
	}

	public static int search(int[] A, int target) {
		int pivot = findPivot(A, 0, A.length - 1);
		// System.out.println(pivot);
		int result = -1;
		if (target == A[0])
			result = 0;
		else if (target > A[0])
			result = Arrays.binarySearch(Arrays.copyOfRange(A, 0, pivot),
					target);
		else {
			result = Arrays.binarySearch(
					Arrays.copyOfRange(A, pivot, A.length), target);
			if (result >= 0)
				result += pivot;
		}
		if (result < 0)
			result = -1;
		return result;
	}

	// where min start
	// e.g. 4,5,1,2,3 return 2
	public static int findPivot(int[] A, int start, int end) {
		//no rotate
		if (A[end] > A[start])
			return A.length;
		//head == tail
		if (A[end] == A[start]){
			boolean flag=false;
			for (int i = end; i >=start; i--) {
				if(A[i]<A[start])
					flag=true;
				else if(A[i]>A[start])
					return i+1;
				else if(A[i]==A[start] && flag)
					return i+1;
			}
			return A.length;
		}
		if (start == end)
			return start;
		else if (end - start == 1) {
			if (A[start] > A[end])
				return end;
		}
		int mid = (start + end) / 2;
		if (A[mid] >= A[start])
			return findPivot(A, mid, end);
		else
			return findPivot(A, start, mid);
	}
	
	public static boolean searchII(int[] A, int target) {
		int pivot = findPivot(A, 0, A.length - 1);
		// System.out.println(pivot);
		int result;
		if (target == A[0])
			return true;
		else if (target > A[0])
			result = Arrays.binarySearch(Arrays.copyOfRange(A, 0, pivot),
					target);
		else {
			result = Arrays.binarySearch(
					Arrays.copyOfRange(A, pivot, A.length), target);
		}
		if (result < 0)
			return false;
		else
			return true;
	}
}
