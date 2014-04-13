package leetcode;
public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { -10, -3, 0, 5, 9 };
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("sorted list");
		// TreeNode.printTree(new ConvertSortedListToBinarySearchTree().sortedListToBST(head));
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int counter = 0;
		ListNode pointer = head;
		while (pointer != null) {
			counter++;
			pointer = pointer.next;
		}
		return constructTree(counter, head);
	}

	public TreeNode constructTree(int n, ListNode head) {
		if (n == 1) {
			TreeNode treeNode = new TreeNode(head.val);
			return treeNode;
		} else if (n == 2) {
			TreeNode treeNode = new TreeNode(head.next.val);
			treeNode.left = new TreeNode(head.val);
			return treeNode;
		} else if (n == 3) {
			TreeNode treeNode = new TreeNode(head.next.val);
			treeNode.left = new TreeNode(head.val);
			treeNode.right = new TreeNode(head.next.next.val);
			return treeNode;
		} else {
			if (n % 2 != 0) {
				ListNode pointer = head;
				for (int i = 1; i < n / 2; i++) {
					pointer = pointer.next;
				}
				TreeNode treeNode = new TreeNode(pointer.next.val);
				treeNode.left = constructTree(n / 2, head);
				treeNode.right = constructTree(n / 2, pointer.next.next);
				return treeNode;
			}else{
				ListNode pointer = head;
				for (int i = 2; i < n / 2; i++) {
					pointer = pointer.next;
				}
				TreeNode treeNode = new TreeNode(pointer.next.val);
				treeNode.left = constructTree(n / 2 - 1, head);
				treeNode.right = constructTree(n / 2, pointer.next.next);
				return treeNode;
			}
		}
	}
}
