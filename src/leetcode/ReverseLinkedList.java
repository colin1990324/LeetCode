package leetcode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,2,3,4,5,6};
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("reversed list");
		ListNode.printListNode(new ReverseLinkedList().reverseBetween(head, 1,4));
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null ||(m==n))
			return head;
		int counter=1;
		ListNode pointer=head;
		if(m==1){
			while(counter<n+1){
				pointer=pointer.next;
				counter++;
			}
			ListNode end=pointer;
			ListNode newHead=reverseBetween(head, n);
			pointer=newHead;
			while(pointer.next!=null)
				pointer=pointer.next;
			pointer.next=end;
			return newHead;
		}
		while(counter<m-1){
			pointer=pointer.next;
			counter++;
		}
		ListNode start=pointer;
		while(counter<n+1){
			pointer=pointer.next;
			counter++;
		}
		ListNode end=pointer;
		start.next=reverseBetween(start.next, n-m+1);
		while(start.next!=null){
			start=start.next;
		}
		start.next=end;
		return head;   
    }
	public ListNode reverseBetween(ListNode head, int n) {
		if(head==null)
			return head;
		if(n==1){
			head.next=null;
			return head;
		}else{
			ListNode subHead=reverseBetween(head.next, n-1);
			ListNode pointer=subHead;
			while(pointer.next!=null){
				pointer=pointer.next;
			}
			pointer.next=head;
			head.next=null;
			return subHead;
		}
    }
}
