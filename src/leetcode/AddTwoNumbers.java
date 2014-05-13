package leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(2);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);
		ListNode b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(4);
		addTwoNumbers(a, b);
	}

	// http://oj.leetcode.com/problems/add-two-numbers/
	// cause I have high precision Multiply(String, String), plus(String,
	// String) method in MultiplyStrings.java
	// for LinkedList here, we convert it into String for the rule required
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String s1 = "";
		String s2 = "";
		ListNode list1 = l1;
		ListNode list2 = l2;
		if (list1 == null)
			s1 = "0";
		if (list2 == null)
			s2 = "0";
		while (list1 != null) {
			s1 = list1.val + s1;
			list1 = list1.next;
		}
		while (list2 != null) {
			s2 = list2.val + s2;
			list2 = list2.next;
		}
		String resultString = MultiplyStrings.plus(s1, s2);
		ListNode resultListNode = new ListNode(resultString.charAt(0) - 48);
		for (int i = 1; i < resultString.length(); i++) {
			ListNode newNode = new ListNode(resultString.charAt(i) - 48);
			newNode.next = resultListNode;
			resultListNode = newNode;
		}
		return resultListNode;
	}
}
