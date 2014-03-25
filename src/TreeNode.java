import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class TreeNode
 * 
 * @author ColinMac
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	/**
	 * Binary Tree Serialization: The serialization of a binary tree follows a
	 * level order traversal, where '#' signifies a path terminator where no
	 * node exists below.
	 * 
	 * @param TreeNode
	 */
	public static void printTree(TreeNode root) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		TreeNode.levelOrderUpDownWithNull(root, arrayList, 0);
		Iterator<ArrayList<Integer>> iterator = arrayList.iterator();
		String string = "";
		while (iterator.hasNext()) {
			ArrayList<Integer> node = iterator.next();
			Iterator<Integer> i = node.iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (n == Integer.MAX_VALUE)
					string += "#, ";
				else
					string += n + ", ";
			}
		}
		System.out.println(string);
	}

	/**
	 * Given a binary tree, find its minimum depth. The minimum depth is the
	 * number of nodes along the shortest path from the root node down to the
	 * nearest leaf node.
	 * 
	 * @param TreeNode
	 * @return int
	 */
	public static int minDepth(TreeNode root) {
		int[] min = { Integer.MAX_VALUE };
		if (root == null)
			min[0] = 0;
		else
			minDepthHelper(root, min, 0);
		return min[0];
	}

	public static void minDepthHelper(TreeNode root, int[] min, int counter) {
		if (root.left == null && root.right == null) {
			if ((counter + 1) < min[0])
				min[0] = counter + 1;
		} else if (counter >= min[0]) {
			return;
		} else {
			if (root.left != null)
				minDepthHelper(root.left, min, counter + 1);
			if (root.right != null)
				minDepthHelper(root.right, min, counter + 1);
		}
	}

	/**
	 * Given a binary tree, determine if it is height-balanced. a
	 * height-balanced binary tree is defined as a binary tree in which the
	 * depth of the two subtrees of every node never differ by more than 1.
	 * 
	 * @param TreeNode
	 * @return boolean
	 */
	public static boolean isBalanced(TreeNode root) {
		if (maxBalancedDepth(root) == -1)
			return false;
		else
			return true;
	}

	/**
	 * Given a binary tree, find its maximum depth. The maximum depth is the
	 * number of nodes along the longest path from the root node down to the
	 * farthest leaf node.
	 * 
	 * @return maximum depth
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {// no leaf
			return 1;
		} else {
			int leftD = maxDepth(root.left);
			int rightD = maxDepth(root.right);
			return Math.max(leftD, rightD) + 1;
		}
	}

	/**
	 * return max depth of a given TreeNode
	 * 
	 * @return if not balance, return -1,else return depth
	 */
	public static int maxBalancedDepth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {// no leaf
			return 1;
		} else if (root.left == null && root.right != null) {// no left leaf
			int depth = maxDepth(root.right);
			if (depth > 1 || depth == -1)
				return -1;
			else
				return 2;
		} else if (root.left != null && root.right == null) {// no right leaf
			int depth = maxDepth(root.left);
			if (depth > 1 || depth == -1)
				return -1;
			else
				return 2;
		} else {
			int leftD = maxDepth(root.left);
			int rightD = maxDepth(root.right);
			if (leftD == -1 || rightD == -1)
				return -1;
			else {
				if (Math.abs(leftD - rightD) > 1)
					return -1;
				else
					return Math.max(leftD, rightD) + 1;
			}
		}
	}

	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 * 
	 * @param int[]
	 * @return TreeNode
	 */
	public static TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 * 
	 * @param int[], int start, int end
	 * @return TreeNode
	 */
	public static TreeNode sortedArrayToBST(int[] num, int s, int e) {
		if (e - s < 0)
			return null;
		else if (e - s == 0) {
			return new TreeNode(num[e]);
		} else if (e - s == 1) {
			TreeNode node = new TreeNode(num[e]);
			node.left = new TreeNode(num[s]);
			return node;
		} else {
			TreeNode node = new TreeNode(num[(e + s) / 2]);
			node.left = sortedArrayToBST(num, s, (e + s) / 2 - 1);
			node.right = sortedArrayToBST(num, (e + s) / 2 + 1, e);
			return node;
		}
	}

	/**
	 * Binary Tree Level Order Traversal
	 * 
	 * @param TreeNode
	 * @return return the level order traversal of its nodes' values. (ie, from
	 *         left to right, level by level).
	 */
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		levelOrderUpDown(root, arrayList, 0);
		return arrayList;
	}

	/**
	 * Binary Tree Level Order Traversal
	 * 
	 * @param TreeNode
	 *            ， ArrayList<ArrayList<Integer>>， int
	 * @return return the level order traversal of its nodes' values. (ie, from
	 *         left to right, level by level).
	 */
	public static void levelOrderUpDown(TreeNode root,
			ArrayList<ArrayList<Integer>> arrayList, int level) {
		if (root == null)
			return;
		else {
			if (arrayList.size() < level + 1) {
				ArrayList<Integer> a = new ArrayList<Integer>();
				arrayList.add(a);
			}
			arrayList.get(level).add(root.val);
			levelOrderUpDown(root.left, arrayList, level + 1);
			levelOrderUpDown(root.right, arrayList, level + 1);
		}
	}

	/**
	 * Binary Tree Level Order Traversal This method is different from
	 * levelOrderUpDown This method add null subtree as Integer.MAX_VALUE
	 * 
	 * @return return the level order traversal of its nodes' values. (ie, from
	 *         left to right, level by level).
	 */
	public static void levelOrderUpDownWithNull(TreeNode root,
			ArrayList<ArrayList<Integer>> arrayList, int level) {
		if (root == null) {
			if (arrayList.size() < level + 1) {
				ArrayList<Integer> a = new ArrayList<Integer>();
				arrayList.add(a);
			}
			arrayList.get(level).add(Integer.MAX_VALUE);
			return;
		} else {
			if (arrayList.size() < level + 1) {
				ArrayList<Integer> a = new ArrayList<Integer>();
				arrayList.add(a);
			}
			arrayList.get(level).add(root.val);
			levelOrderUpDownWithNull(root.left, arrayList, level + 1);
			levelOrderUpDownWithNull(root.right, arrayList, level + 1);
		}
	}

	/**
	 * Binary Tree Level Order Traversal II
	 * 
	 * @param TreeNode
	 * @return return the bottom-up level order traversal of its nodes' values.
	 *         (ie, from left to right, level by level from leaf to root).
	 */
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		levelOrderUpDown(root, arrayList, 0);
		ArrayList<ArrayList<Integer>> reverseArrayList = new ArrayList<ArrayList<Integer>>();
		for (int i = arrayList.size() - 1; i > -1; i--) {
			reverseArrayList.add(arrayList.get(i));
		}
		return reverseArrayList;
	}

	/**
	 * Given a binary tree, return the zigzag level order traversal of its
	 * nodes' values. (ie, from left to right, then right to left for the next
	 * level and alternate between).
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		levelOrderUpDown(root, arrayList, 0);
		ArrayList<ArrayList<Integer>> zigArrayList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < arrayList.size(); i++) {
			if (i % 2 == 0)
				zigArrayList.add(arrayList.get(i));
			else {
				ArrayList<Integer> a = new ArrayList<Integer>();
				for (int j = arrayList.get(i).size() - 1; j > -1; j--) {
					a.add(arrayList.get(i).get(j));
				}
				zigArrayList.add(a);
			}
		}
		return zigArrayList;
	}

	/**
	 * Given two binary trees, check if they are equal or not. Two binary trees
	 * are considered equal if they are structurally identical and the nodes
	 * have the same value.
	 * 
	 * @return boolean is the same tree or not
	 */
	public static boolean isSameTree(TreeNode treeA, TreeNode treeB) {
		if (treeA == null) {
			if (treeB == null)
				return true;
			else
				return false;
		} else {
			if (treeB == null)
				return false;
			else {
				if (treeA.val == treeB.val) {
					return (isSameTree(treeA.left, treeB.left) && isSameTree(
							treeA.right, treeB.right));
				} else
					return false;
			}
		}
	}

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		return isSubtreeSymmetric(root.left, root.right);
	}

	/**
	 * Given two binary trees, check whether they are symmetric
	 * 
	 * @return boolean
	 */
	public static boolean isSubtreeSymmetric(TreeNode treeA, TreeNode treeB) {
		if (treeA == null) {
			if (treeB == null)
				return true;
			else
				return false;
		} else {
			if (treeB == null)
				return false;
			else {
				if (treeA.val == treeB.val) {
					return (isSubtreeSymmetric(treeA.left, treeB.right) && isSubtreeSymmetric(
							treeA.right, treeB.left));
				} else
					return false;
			}
		}
	}

	/**
	 * @param n
	 * @return how many structurally unique BST's (binary search trees) that
	 *         store values 1...n
	 */
	public static int numTrees(int n) {
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			arrayList.add(i);
		int counter = 0;
		for (int i = 0; i < n; i++) {
			counter += numTreesHelper(arrayList, i);
		}
		return counter;
	}

	public static int numTreesHelper(ArrayList<Integer> a, int n) {
		if (a.size() == 2)
			return 2;
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arrayList = (ArrayList<Integer>) a.clone();
		arrayList.remove(n);
		int counter = 0;
		return n;
	}
}
