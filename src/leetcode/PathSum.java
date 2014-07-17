package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PathSum {

	// Given a binary tree and a sum, determine if the tree has a root-to-leaf
	// path such that adding up all the values along the path equals the given
	// sum.
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(-1);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(-1);
		root.left.right.right = new TreeNode(0);
		root.right.left.left = new TreeNode(-1);
		root.right.left.right = new TreeNode(0);
		root.right.right.left = new TreeNode(1);
		root.right.right.right = new TreeNode(0);
		TreeNode.breathFirstTraversalIterative(root);
		System.out.println(pathSum(root, 2));
	}

	public static boolean hasPathSumII(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum && root.left == null && root.right == null)
			return true;
		HashSet<Integer> leftSet = new HashSet<Integer>();
		HashSet<Integer> rightSet = new HashSet<Integer>();
		if (hasPathSumII(root.left, sum, leftSet)
				|| hasPathSumII(root.right, sum, rightSet))
			return true;
		else {
			for (int i : leftSet) {
				for (int j : rightSet) {
					if (i + j + root.val == sum || i + root.val == sum
							|| j + root.val == sum)
						return true;
				}
			}
		}
		return false;
	}

	private static boolean hasPathSumII(TreeNode root, int sum,
			HashSet<Integer> set) {
		if (root == null)
			return false;
		if (root.val == sum)
			return true;
		HashSet<Integer> leftSet = new HashSet<Integer>();
		HashSet<Integer> rightSet = new HashSet<Integer>();
		if (hasPathSumII(root.left, sum, leftSet)
				|| hasPathSumII(root.right, sum, rightSet))
			return true;
		else {
			for (int i : leftSet) {
				for (int j : rightSet) {
					if (i + j + root.val == sum || i + root.val == sum
							|| j + root.val == sum)
						return true;
				}
			}
		}
		for (int i : leftSet) {
			set.add(i + root.val);
		}
		for (int j : rightSet) {
			set.add(j + root.val);
		}
		set.add(root.val);
		return false;
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}

	// https://oj.leetcode.com/problems/path-sum-ii/
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null)
			return lists;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		if (root.val == sum && root.left == null && root.right == null)
			lists.add(list);
		else {
			pathSum(root.left, sum - root.val, lists, new ArrayList<Integer>(
					list));
			pathSum(root.right, sum - root.val, lists, new ArrayList<Integer>(
					list));
		}
		return lists;
	}

	private static void pathSum(TreeNode root, int sum,
			List<List<Integer>> lists, ArrayList<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			lists.add(list);
			return;
		} else {
			pathSum(root.left, sum - root.val, lists, new ArrayList<Integer>(
					list));
			pathSum(root.right, sum - root.val, lists, new ArrayList<Integer>(
					list));
		}
	}
}
