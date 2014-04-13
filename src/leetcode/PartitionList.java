package leetcode;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2,1};
		int x=1;
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("partitioned list");
		ListNode.printListNode(new PartitionList().partition(head,x));
	}
	public ListNode partition(ListNode head, int x) {
		ListNode pointerA=new ListNode(1);
		ListNode pointerB=new ListNode(1);
		ListNode pointer=head;
		ListNode pointerAA=pointerA;
		ListNode pointerBB=pointerB;
		while(pointer!=null){
			if(pointer.val<x){
				pointerAA.next=pointer;
				pointerAA=pointerAA.next;
				pointer=pointer.next;
			}else{
				pointerBB.next=pointer;
				pointerBB=pointerBB.next;
				pointer=pointer.next;
			}
		}
		pointerAA.next=null;
		pointerBB.next=null;
		//merge
		ListNode result;
		if(pointerA.next==null){
			result=pointerB.next;
		}else{
			pointerAA.next=pointerB.next;
			result=pointerA.next;
		}
		return result;
    }
}
