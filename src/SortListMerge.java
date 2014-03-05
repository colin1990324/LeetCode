
public class SortListMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={56, 32, 5, 12, 22, 4, 2, 9, 232, 51, 28, 32, 37};
		ListNode head=array2ListNode(array);
		System.out.println("original list");
		printListNode(head);
		System.out.println("sorted list");
		printListNode(new SortListMerge().sortList(head));
	}
	public ListNode sortList(ListNode head) {
		int length=0;
		ListNode pointer=head;
		//count length
		while(pointer!=null){
			length++;
			pointer=pointer.next;
		}
		//unit then return itself
		if(length==0)
			return null;
		if (length==1) {
			return head;
		}
		if (length==2) {
			if(head.val>head.next.val){
				ListNode temp=head.next;
				temp.next=head;
				temp.next.next=null;
				head=temp;
			}
			return head;
		}
		//break into two list
		pointer=head;
		for(int i=1;i<length/2;i++){
			pointer=pointer.next;
		}
		ListNode headB=pointer.next;
		ListNode headA=head;
		pointer.next=null;
		//sort two sub list
		headB=sortList(headB);
		headA=sortList(headA);
		//merge
		ListNode mergedlist;
		if(headA.val<=headB.val){
			mergedlist=headA;
			headA=headA.next;
		}else{
			mergedlist=headB;
			headB=headB.next;
		}
		pointer=mergedlist;
		do {
			if(headA==null){
				pointer.next=headB;
				break;
			}
			if(headB==null){
				pointer.next=headA;
				break;
			}
			if(headA.val<=headB.val){
				pointer.next=headA;
				headA=headA.next;
				pointer=pointer.next;
			}else{
				pointer.next=headB;
				headB=headB.next;
				pointer=pointer.next;
			}
		} while (true);
		return mergedlist;
	}
	public static ListNode array2ListNode(int[] array) {
		if (array.length==0){
			return null;
		}
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
		if(pointer==null)
			return;
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