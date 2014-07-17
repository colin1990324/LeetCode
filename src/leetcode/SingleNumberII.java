package leetcode;
import java.util.HashMap;
import java.util.Iterator;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 3, 1, 2, 2, 2 };
		System.out.println(singleNumber(A));
	}

	public static int singleNumber(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			if (!map.containsKey(a))
				map.put(a, 1);
			else if (map.get(a) == 1)
				map.put(a, 2);
			else
				map.remove(a);
		}
		Iterator<Integer> iterator = map.keySet().iterator();
		return iterator.next();
	}
}
