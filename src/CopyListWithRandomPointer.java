import java.util.ArrayList;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 3,2,4,5};
		RandomListNode head = RandomListNode.array2ListNode(array);
		System.out.println("original list");
		RandomListNode.printListNode(head);
		RandomListNode.printListNode(copyRandomList(head));
	}
	public static RandomListNode copyRandomList(RandomListNode head) {
		//empty list
		if(head==null)
            return null;
		//arraylist
		ArrayList<RandomListNode> A=new ArrayList<RandomListNode>();
		ArrayList<RandomListNode> B=new ArrayList<RandomListNode>();
		//new list head
		RandomListNode newHead=new RandomListNode(head.label);
		//first scan and construct trunk
		RandomListNode pointerA=head;
		RandomListNode pointerB=newHead;
		A.add(head);
		B.add(newHead);
		while(pointerA.next!=null){
			RandomListNode n=new RandomListNode(pointerA.next.label);
			A.add(pointerA.next);
			B.add(n);
			pointerB.next=n;
			pointerA=pointerA.next;
			pointerB=pointerB.next;
		}
		//for single node list which link to itself
		if(head.next==null && head.random==head){
			newHead.random=newHead;
			return newHead;
		}
		//second scan link all the random
		pointerA=head;
		pointerB=newHead;
		while(pointerA!=null){
			if(pointerA.random==null){
				pointerA=pointerA.next;
				pointerB=pointerB.next;
				continue;
			}
			for(int i=0; i<A.size();i++){
				if(A.get(i)==pointerA.random){
					pointerB.random=B.get(i);
					break;
				}
			}
			pointerA=pointerA.next;
			pointerB=pointerB.next;
		}
		return newHead;
    }
}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) {
		this.label = x;
	}
	public static RandomListNode array2ListNode(int[] array) {
		if (array.length == 0) {
			return null;
		}
		RandomListNode head = new RandomListNode(array[0]);
		RandomListNode pointer = head;
		for (int i = 1; i < array.length; i++) {
			pointer.next = new RandomListNode(array[i]);
			pointer = pointer.next;
		}
		pointer.next = null;
		return head;
	}
	public static void printListNode(RandomListNode head) {
		RandomListNode pointer = head;
		String string = "";
		if (pointer == null)
			return;
		while (pointer != null) {
			string += pointer.label + ", ";
			pointer = pointer.next;
		}
		System.out.println(string.substring(0, string.length() - 2));
	}
}