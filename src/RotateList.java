
public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,2,3,4,5};
		ListNode head = ListNode.array2ListNode(array);
		System.out.println("original list");
		ListNode.printListNode(head);
		System.out.println("reversed list");
		ListNode.printListNode(new RotateList().rotateRight(head, 3));
	}
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n==0)
            return head;
        ListNode pointer=head;
        int counter=0;
        while(pointer!=null){
            counter++;
            pointer=pointer.next;
        }
        if(counter==1 || counter==n)
            return head;
        if(counter<n)
        	return rotateRight(head, n%counter);
        pointer=head;
        for(int i=0; i<counter-n-1;i++){
            pointer=pointer.next;
        }
        ListNode newHead=pointer.next;
        ListNode last=pointer;
        for(int i=0; i<n;i++){
            pointer=pointer.next;
        }
        pointer.next=head;
        last.next=null;
        return newHead;
    }
}
