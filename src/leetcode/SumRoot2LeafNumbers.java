package leetcode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SumRoot2LeafNumbers {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		System.out.println(sumNumbers(root));
	}

	public static int sumNumbers(TreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;
		if (root.right == null && root.left == null)
			return root.val;
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		sumNumbersHelper(root.left, lists, new ArrayList<Integer>(list));
		sumNumbersHelper(root.right, lists, new ArrayList<Integer>(list));
		Iterator<List<Integer>> iterator = lists.iterator();
		while (iterator.hasNext()) {
			Iterator<Integer> i = iterator.next().iterator();
			int num = 0;
			while (i.hasNext()) {
				num = num * 10 + i.next();
			}
			sum += num;
		}
		return sum;
	}

	private static void sumNumbersHelper(TreeNode root,
			List<List<Integer>> lists, ArrayList<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		if (root.left == null && root.right == null) {
			lists.add(list);
		} else {
			sumNumbersHelper(root.left, lists, new ArrayList<Integer>(list));
			sumNumbersHelper(root.right, lists, new ArrayList<Integer>(list));
		}
	}
}
