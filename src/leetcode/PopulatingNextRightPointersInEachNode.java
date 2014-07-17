package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(1);
		root.right = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(3);
		root.left.right = new TreeLinkNode(4);
		root.right.left = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(6);
		connect(root);
	}

	// BFS go through the tree by layer
	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		int level = 0;
		int counter = 0;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		TreeLinkNode leftNode = null;
		while (!queue.isEmpty()) {
			TreeLinkNode current = queue.poll();
			if (leftNode != null)
				leftNode.next = current;
			if (current.left != null)
				queue.offer(current.left);
			if (current.right != null)
				queue.offer(current.right);
			leftNode = current;
			counter++;
			if (counter == Math.pow(2, level)) {
				current.next = null;
				leftNode = null;
				level++;
				counter = 0;
			}
		}
		System.out.println("complete");
	}
}
