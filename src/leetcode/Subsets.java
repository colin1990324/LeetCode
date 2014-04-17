package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 3 };
		int[] B = { 1, 2, 2 };
		ArrayList<ArrayList<Integer>> result = subsets(A);
		result = subsets(B);
		System.out.println(A);
	}

	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		subsetHelperII(S, new ArrayList<Integer>(), 0, result);
		result.add(new ArrayList<Integer>());
		return result;
	}

	// non-duplicated element
	public static void subsetHelper(int[] S, ArrayList<Integer> list,
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
	public static void subsetHelperII(int[] S, ArrayList<Integer> list,
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
