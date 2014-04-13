package leetcode;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,2,3,4,5};
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("reordered list");
		new ReorderList().reorderList(head);
		ListNode.printListNode(head);
	}
	public void reorderList(ListNode head) {
	    // IMPORTANT: Please reset any member data you declared, as
	    // the same Solution instance will be reused for each test case.
	    if (head == null || head.next == null) return;
	    ListNode fast = head;
	    ListNode slow = head;
	    while(fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    ListNode reverseHead = slow.next;           // find the second half of list
	    slow.next = null;                           // make first half end point to null
	    reverseHead = reverse(reverseHead);         // reverse second half     
	    ListNode cur = head;        
	    while(reverseHead != null) {                // link together
	        ListNode tmp = reverseHead.next;
	        reverseHead.next = cur.next;
	        cur.next = reverseHead;
	        cur = cur.next.next;
	        reverseHead = tmp;
	    }
	}
	ListNode reverse(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode prev = new ListNode(0);
	    prev.next = head;
	    head = prev;
	    ListNode cur = prev.next;
	    while(cur.next != null) {
	        ListNode tmp = cur.next;
	        cur.next = tmp.next;
	        tmp.next = prev.next;
	        prev.next = tmp;
	    }
	    return prev.next;
	}
}
