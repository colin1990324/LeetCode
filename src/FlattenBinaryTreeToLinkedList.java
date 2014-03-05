public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode aNode=new TreeNode(1);
		aNode.right=new TreeNode(2);
		aNode.right.right=new TreeNode(4);
		aNode.right.right.left=new TreeNode(3);
		new FlattenBinaryTreeToLinkedList().flatten(aNode);
	}
	//flatten and return sorted result
	void flattenWithSort(TreeNode aNode) {
		if(aNode==null)
		    return;
		TreeNode pointer=new TreeNode(0);
		mergeSort(aNode, pointer);
		aNode=pointer.right;
	}
	void mergeSort(TreeNode aNode, TreeNode pointer) {
		// TODO Auto-generated method stub
		if(aNode.left!=null)
			mergeSort(aNode.left, pointer);
		if(aNode.right!=null)
			mergeSort(aNode.right, pointer);
		merge(aNode, pointer);
	}
	void merge(TreeNode aNode, TreeNode pointer) {
		//head is null, new list, set as beginning
		if(pointer.right==null){
			pointer.right=aNode;
			aNode.right=null;
		}else{  //
			while (pointer.right!=null) {
				if (pointer.right.val>aNode.val) {
					TreeNode tmp=pointer.right;
					pointer.right=aNode;
					aNode.right=tmp;
					return;
				}else {
					pointer=pointer.right;
				}
			}
			pointer.right=aNode;
			aNode.right=null;
		}
	}
	//flatten without sort
	void flatten(TreeNode root) {
        help(root);
    }
    TreeNode help(TreeNode root){
        if(root==null) return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        if(l!=null){
            root.right = help(l);
            root.left = null;
            TreeNode rightmost = l;
            while(rightmost.right!=null)
                rightmost = rightmost.right;
            rightmost.right = r;
        }
        help(r);
        return root;
    }
}
