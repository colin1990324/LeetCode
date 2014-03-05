public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// for any root, the path could go through it or not
	// if yes: max could be one of: max(left)+val, max(right)+val, val
	// if not: could be one of: best ever, max(left), max(right),max(left)+
	// max(right)+val
	public int maxPathSum(TreeNode root) {
		int[] r = helper(root);
		return r[1];
	}

	private int[] helper(TreeNode node) {
		if (node == null)
			return new int[] { 0, Integer.MIN_VALUE };

		int[] left = helper(node.left);
		int[] right = helper(node.right);

		int[] r = new int[2];
		r[0] = Math.max(node.val,
				Math.max(node.val + left[0], node.val + right[0]));

		r[1] = Math.max(Math.max(r[0], Math.max(left[1], right[1])), left[0]
				+ right[0] + node.val);
		return r;
	}
}
