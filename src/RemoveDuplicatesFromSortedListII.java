/*
 * feel like recursion is the best for linked list (or sorted list?)
 * at least try on RemoveDuplicatesromSortedList I
 */

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,1,3,4,4,5,5,5,1};
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("sorted list");
		ListNode.printListNode(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
	}
	public ListNode deleteDuplicates(ListNode head) {
		//empty list
		if(head==null)
			return head;
		//one node
		if (head.next==null) {
			return head;
		}
		//more than two node
		int val=head.val;
		ListNode pointer=head.next;
		if (val == pointer.val) {
			while (val == pointer.val) {
				if (pointer.next == null)
					return null;
				else
					pointer = pointer.next;
			}
			return deleteDuplicates(pointer);
		}else {
			head.next=deleteDuplicates(head.next);
			return head;
		}
	}
}
