package leetcode;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] arg) {
		int i = 30;
		System.out.println(generate(i + 1).get(i));
		System.out.println(getRow(i));
	}

	// https://oj.leetcode.com/problems/pascals-triangle/
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		// 0
		if (numRows < 1)
			return lists;
		// 1
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		lists.add(list1);
		if (numRows == 1)
			return lists;
		// 2 and more
		List<Integer> last = list1;
		for (int i = 2; i <= numRows; i++) {
			last = nextLevel(last);
			lists.add(last);
		}
		return lists;
	}

	private static List<Integer> nextLevel(List<Integer> list) {
		List<Integer> nextList = new ArrayList<Integer>();
		nextList.add(1);
		for (int i = 0; i < list.size() - 1; i++) {
			nextList.add(list.get(i) + list.get(i + 1));
		}
		nextList.add(1);
		return nextList;
	}

	// https://oj.leetcode.com/problems/pascals-triangle-ii/
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		long last = 1;
		long current;
		for (int i = 1; i < rowIndex + 1; i++) {
			current = last * (rowIndex + 1 - i) / i;
			list.add((int) current);
			last = current;
		}
		return list;
	}

}
