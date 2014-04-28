package leetcode;

import java.util.HashMap;

public class LRUCacheLinkedList {
	int capacity;
	HashMap<Integer, CacheListNode> address = new HashMap<Integer, CacheListNode>();
	CacheListNode listHead;
	CacheListNode listTail;

	public LRUCacheLinkedList(int capacity) {
		this.capacity = capacity;
		listHead = null;
		listTail = listHead;
	}

	public int get(int key) {
		if (address.containsKey(key)) {
			CacheListNode node = address.get(key);
			// move to list head
			if (node != listHead) {
				node.pre.next = node.next;
				if (node.next == null)
					listTail = node.pre;
				node.next = listHead;
				listHead.pre=node;
				listHead = node;
				if (node.next.next != null)
					listHead.next.next.pre=listHead.next;
			}
			return node.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (address.containsKey(key)) {
			CacheListNode node = address.get(key);
			// move to list head
			if (node != listHead) {
				node.pre.next = node.next;
				if (node.next == null)
					listTail = node.pre;
				node.next = listHead;
				listHead.pre=node;
				listHead = node;
				if (node.next.next != null)
					listHead.next.next.pre=listHead.next;
			}
			// update value
			node.value = value;
		} else {
			if (address.size() == capacity) {
				address.remove(listTail.key);
				if (capacity == 1)
					listHead = null;
				else {
					listTail=listTail.pre;
					listTail.next = null;
				}
			}
			CacheListNode node = new CacheListNode(key, value);
			node.next = listHead;
			listHead = node;
			if(listHead.next!=null)
				listHead.next.pre=listHead;
			address.put(key, node);
			if (address.size() == 1)
				listTail = node;
		}
	}

	public static void main(String[] args) {
		LRUCacheLinkedList cache = new LRUCacheLinkedList(3);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.set(5, 5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}
}

class CacheListNode {
	public int key;
	public int value;
	public CacheListNode next;
	public CacheListNode pre;

	public CacheListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}