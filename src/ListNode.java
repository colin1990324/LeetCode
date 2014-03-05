
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	public static ListNode array2ListNode(int[] array) {
		if (array.length == 0) {
			return null;
		}
		ListNode head = new ListNode(array[0]);
		ListNode pointer = head;
		for (int i = 1; i < array.length; i++) {
			pointer.next = new ListNode(array[i]);
			pointer = pointer.next;
		}
		pointer.next = null;
		return head;
	}

	public static void printListNode(ListNode head) {
		ListNode pointer = head;
		String string = "";
		if (pointer == null)
			return;
		while (pointer != null) {
			string += pointer.val + ", ";
			pointer = pointer.next;
		}
		System.out.println(string.substring(0, string.length() - 2));
	}
	public static ListNode reverse(ListNode head) {
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
