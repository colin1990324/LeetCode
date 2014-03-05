
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayA = { 1,2,3};
		int[] arrayB = { 1,1,4};
		ListNode headA = ListNode.array2ListNode(arrayA);
		ListNode headB = ListNode.array2ListNode(arrayB);
		System.out.println("original list");
		ListNode.printListNode(headA);
		ListNode.printListNode(headB);
		System.out.println("merged list");
		ListNode.printListNode(new MergeTwoSortedLists().mergeTwoLists(headA,headB));
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newHead=new ListNode(1);
		ListNode pointer=newHead;
		ListNode pointerA=l1;
		ListNode pointerB=l2;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		while(pointerA!=null && pointerB!=null){
			if(pointerA.val<pointerB.val){
				pointer.next=pointerA;
				pointerA=pointerA.next;
				pointer=pointer.next;
			}else{
				pointer.next=pointerB;
				pointerB=pointerB.next;
				pointer=pointer.next;
			}
		}
		if(pointerA==null){
			pointer.next=pointerB;
		}
		if(pointerB==null)
			pointer.next=pointerA;
		return newHead.next;
    }
}
