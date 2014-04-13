package leetcode;

public class RemoveDuplicatesromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,1,3,2,4,4};
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("sorted list");
		ListNode.printListNode(new RemoveDuplicatesromSortedList().deleteDuplicates(head));
	}
	public ListNode deleteDuplicates(ListNode head) {
		ListNode pointer=head;
		while(pointer!=null){
			if(pointer.next==null){
				return head;
			}else{
				if(pointer.val==pointer.next.val){
					pointer.next=pointer.next.next;
					continue;
				}else{
					pointer=pointer.next;
					continue;
				}
			}
		}
		return head;
    }
}
