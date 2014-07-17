package leetcode;

public class SortListQuick {

	public static void main(String[] args) {
		int[] array={56, 32, 5, 12, 22, 4, 2, 9, 232, 51, 28, 32, 37};
		ListNode head=array2ListNode(array);
		printListNode(head);
	}
	public static ListNode sortList(ListNode head){
		
		return head;
	}

	public static ListNode array2ListNode(int[] array) {
		ListNode head=new ListNode(array[0]);
		ListNode pointer=head;
		for(int i=1;i<array.length;i++){
			pointer.next=new ListNode(array[i]);
			pointer=pointer.next;
		}
		pointer.next=null;
		return head;	
	}
	public static void printListNode(ListNode head) {
		ListNode pointer=head;
		String string="";
		while(pointer!=null){
			string+=pointer.val+", ";
			pointer=pointer.next;
		}
		System.out.println(string.substring(0, string.length()-2));
	}
}	

//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}