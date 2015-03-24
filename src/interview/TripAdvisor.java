package interview;

/**
 * given a tree
 * find max difference between node values in a path
 * path is defend by only go up and down
 * @author ColinMac
 *
 */
public class TripAdvisor {

	public int solution(Tree T) {
		int[] r = helper(T);
		return r[1] - r[0];
		
	}

	private int[] helper(Tree node) {
		if (node == null)
			return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };

		int[] left = helper(node.l);
		int[] right = helper(node.r);

		if (node.x < left[0])
			left[0] = node.x;
		if (node.x > left[1])
			left[1] = node.x;
		if (node.x < right[0])
			right[0] = node.x;
		if (node.x > right[1])
			right[1] = node.x;

		if (left[1] - left[0] > right[1] - left[0])
			return left;
		else
			return right;
	}

	class Tree {
		int x;
		Tree l;
		Tree r;
	}
}
