public class SortListInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 3,2,4};
		ListNode head = array2ListNode(array);
		System.out.println("original list");
		printListNode(head);
		System.out.println("sorted list");
		printListNode(new SortListInsert().sortList(head));
	}

	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		ListNode sortedHead = head;
		ListNode pointer = head.next;
		sortedHead.next = null;
		while (pointer != null) {
			if (pointer.val <= sortedHead.val) {
				ListNode tmp = pointer.next;
				pointer.next = sortedHead;
				sortedHead = pointer;
				pointer = tmp;
			} else {
				if (sortedHead.next == null) {
					sortedHead.next = pointer;
					pointer = pointer.next;
					sortedHead.next.next = null;
					continue;
				} else {
					ListNode pointerSorted = sortedHead;
					boolean foundSmaller = false;
					do {
						if (pointer.val <= pointerSorted.next.val) {
							ListNode tmp = pointer.next;
							pointer.next = pointerSorted.next;
							pointerSorted.next = pointer;
							pointer = tmp;
							foundSmaller = true;
							break;
						}else {
							pointerSorted=pointerSorted.next;
						}
					} while (pointerSorted.next != null);
					if (!foundSmaller) {
						pointerSorted.next = pointer;
						ListNode tmp = pointer.next;
						pointer.next = null;
						pointer = tmp;
					}
				}
			}
		}
		return sortedHead;
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
}
//
//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}