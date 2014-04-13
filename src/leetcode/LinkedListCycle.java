package leetcode;
/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?*/

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		//head.next=head;
		head.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l2;
		System.out.println(head);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		System.out.println(new LinkedListCycle().detectCycle(head));
	}
	//normal way: O(n^2)
	public boolean hasCycle(ListNode head) {
		ListNode pointerA=head;
		ListNode pointerB;
		while(pointerA!=null){
			pointerB=head;
			while(pointerA.next!=null){
				if(pointerA.next==pointerB){
					return true;
				}else{
					if(pointerB.next==null || pointerB==pointerA)
						break;
					else
						pointerB=pointerB.next;
				}
			}
			pointerA=pointerA.next;
		}
		return false;
    }	
	//two runner O(2n)
	public boolean hasCycleTwoRunner(ListNode head) {
		if(head==null)
			return false;
		if(head.next==null)
			return false;
		ListNode fastRunner=head.next.next;
		ListNode slowRunner=head.next;
		while(fastRunner!=null){
			if(fastRunner==slowRunner)
				return true;
			else{
				if(fastRunner.next==null)
					break;
				if(fastRunner.next.next==null)
					break;
				fastRunner=fastRunner.next.next;
				slowRunner=slowRunner.next;
			}
		}
		return false;
	}
	/*return cycle start node
	x is head from cycle enter node
	y is cycle length
	m is meet node from enter node
	fast run=x+ky+m
	slow run=x+ty+m
	fast=2*slow ==> ky=x+2ty+m
	(k-2t)y=x+m ==> x+m mod y
	then fasw run more x step to reach enter node*/
	public ListNode detectCycle(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		do{
			if(slow==null || fast==null)
				return null;
			slow=slow.next;
			fast=fast.next;
			if(slow==null || fast==null)
				return null;
			if(fast.next!=null)
				fast=fast.next;
			else 
				return null;
		}while(slow!=fast);
		slow=head;
		while (slow!=fast) {
			slow=slow.next;
			fast=fast.next;
			
		}
		return slow;
    }
}
