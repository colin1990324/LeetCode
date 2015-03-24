package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		int[] A = { 2, 1 };
		System.out.println(new LargestNumber().largestNumber(A));
		
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		String d = new String("abc");
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(c==d);
		System.out.println(c.equals(d));
	}

	public String largestNumber(int[] num) {
		String res = "";
		Integer[] a = intToObject(num);
		Arrays.sort(a, new NewIntComparator());
		for (int i : a)
			res = i + res;
		return res;
	}
	
	

	class NewIntComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			char[] a = o1.toString().toCharArray();
			char[] b = o2.toString().toCharArray();
			int l = Math.min(a.length, b.length);
			for (int i = 0; i < l; i++) {
				if (a[i] > b[i])
					return 1;
				if (a[i] < b[i])
					return -1;
			}
			if (l != 0) {
				return (a.length > b.length) ? -1 : 1;
			}
			return 0;
		}
	}

	static Integer[] intToObject(int... arr) {
		Integer[] a = new Integer[arr.length];
		int cnt = 0;
		for (int val : arr)
			a[cnt++] = new Integer(val);
		return a;
	}

	static int[] intObjToPrimitive(Integer... arr) {
		int[] a = new int[arr.length];
		int cnt = 0;
		for (Integer val : arr)
			if (val != null)
				a[cnt++] = val.intValue();
		return a;

	}
}
