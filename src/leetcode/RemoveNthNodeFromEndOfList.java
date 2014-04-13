package leetcode;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,2,3,4};
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("reversed list");
		ListNode.printListNode(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2));
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head ==null || n<1)
			return head;
		ListNode pointer=new ListNode(1);
		pointer.next=head;
		int counter=0;
		ListNode nthFromEnd = pointer;
		while(pointer.next!=null){
			if(counter==n){
				nthFromEnd=nthFromEnd.next;
			}else{
				counter++;
			}
			pointer=pointer.next;
		}
		if(nthFromEnd.next==head)
			return head.next;
		else {
			nthFromEnd.next=nthFromEnd.next.next;
		}
		return head;   
    }
}
