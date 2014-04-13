package leetcode;
import java.util.ArrayList;


public class BasicClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = { 0,1,2,3,4,5};
//		RandomListNode head = RandomListNode.array2ListNode(array);
//		System.out.println("original list");
//		RandomListNode.printListNode(head);
//		TreeNode.sortedArrayToBST(array);
//		TreeNode root=new TreeNode(1);
//		root.right=new TreeNode(2);
//		root.right.right=new TreeNode(4);
//		root.right.right.left=new TreeNode(3);
//		TreeNode root2=new TreeNode(1);
//		root2.right=new TreeNode(2);
//		root2.right.right=new TreeNode(4);
//		root2.right.right.right=new TreeNode(3);
////		TreeNode.printTree(root);
//		System.out.println(TreeNode.isSameTree(root, root2));
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		ArrayList<Integer> arrayList2=(ArrayList<Integer>) arrayList.clone();
		arrayList2.remove(0);
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.get(1));
		System.out.println(arrayList2.get(0));
	}

}
