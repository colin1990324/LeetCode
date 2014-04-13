package leetcode;
import java.util.ArrayList;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// preorderTraversal
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		preorderTraversal(root, arrayList);
		return arrayList;
	}

	public void preorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
		if (root == null)
			return;
		arrayList.add(root.val);
		preorderTraversal(root.left, arrayList);
		preorderTraversal(root.right, arrayList);
	}

	// postorderTraversal
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		postorderTraversal(root, arrayList);
		return arrayList;
	}

	public void postorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
		if (root == null)
			return;
		postorderTraversal(root.left, arrayList);
		postorderTraversal(root.right, arrayList);
		arrayList.add(root.val);
	}

	// inorderTraversal
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		inorderTraversal(root, arrayList);
		return arrayList;
	}

	public void inorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
		if (root == null)
			return;
		inorderTraversal(root.left, arrayList);
		arrayList.add(root.val);
		inorderTraversal(root.right, arrayList);
	}
}
