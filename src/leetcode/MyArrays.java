package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MyArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 2 };
		int[] B = { 1, 2, 2, 3 };
		//System.out.println(searchRange(B, 2)[0]+" "+searchRange(B, 2)[1]);
		System.out.println(singleNumber(A));
	}
	
	public static int singleNumber(int[] A) {
		int length=A.length;
		if(length==1){
	        return A[0];
	    }
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
			if(map.get(A[i])==null)
				map.put(A[i], 1);
			else
				map.remove(A[i]);
		}
        return map.entrySet().iterator().next().getKey();
    }
	
	public static int[] searchRange(int[] A, int target) {
		int[] result={-1,-1};
        int index=Arrays.binarySearch(A, target);
        //no target
        if(index<0)
        	return result;
        //find start
        if(index-1<0 || A[index-1]!=target)
        	result[0]=index;
        //find end
        if(index+1==A.length || A[index+1]!=target)
        	result[1]=index;
        //continue search
        if(result[0]==-1)
        	result[0]=searchRange(Arrays.copyOfRange(A, 0, index), target)[0];
        if(result[1]==-1)
        	result[1]=searchRange(Arrays.copyOfRange(A, index+1, A.length), target)[1]+index+1;
        return result;
    }
	
	
	public static int removeElement(int[] A, int elem) {
        int length=A.length;
        for (int i = 0; i < A.length; i++) {
			if(i<length-1 && A[i]==elem){
				if(A[length-1]!=elem)
					A[i]=A[length-1];
				length--;
				i--;
			}else if(i==length-1){
				if(A[length-1]==elem)
		        	length--;
				break;
			}
		}
        return length;
    }

	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		subsetHelper(S, new ArrayList<Integer>(), 0, result);
		result.add(new ArrayList<Integer>());
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> subsetsDup(int[] S) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		subsetHelperII(S, new ArrayList<Integer>(), 0, result);
		result.add(new ArrayList<Integer>());
		return result;
	}

	// non-duplicated element
	private static void subsetHelper(int[] S, ArrayList<Integer> list,
			int index, ArrayList<ArrayList<Integer>> result) {
		if (index == S.length)
			return;
		// not choose
		subsetHelper(S, list, index + 1, result);
		// choose
		ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
		newList.add(S[index]);
		result.add(newList);
		subsetHelper(S, newList, index + 1, result);
	}

	// allow duplication, also works will with non-duplicated cases
	private static void subsetHelperII(int[] S, ArrayList<Integer> list,
			int index, ArrayList<ArrayList<Integer>> result) {
		if (index == S.length)
			return;
		int duplicates = 1;
		for (int i = index; i < S.length - 1; i++) {
			if (S[i] == S[i + 1])
				duplicates++;
			else
				break;
		}
		// choose
		for (int i = 1; i <= duplicates; i++) {
			ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
			for (int j = 0; j < i; j++) {
				newList.add(S[index]);
			}
			result.add(newList);
			subsetHelperII(S, newList, index + duplicates, result);
		}
		// not chose
		subsetHelperII(S, list, index + duplicates, result);
	}
}
