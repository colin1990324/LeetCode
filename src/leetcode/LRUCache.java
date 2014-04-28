package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	
	int capacity;
	int counter;
	HashMap<Integer, Integer> cache=new HashMap<Integer, Integer>();
	LinkedList<Integer> queue=new LinkedList<Integer>();
	public LRUCache(int capacity) {
        this.capacity=capacity;
        this.counter=0;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
        	queue.remove((Integer) key);
        	queue.offer(key);
			return cache.get(key);
		}else {
			return -1;
		}
    }
    
    public void set(int key, int value) {
    	if (cache.containsKey(key)) {
			cache.remove(key);
			cache.put(key, value);
			queue.remove((Integer) key);
		}else {
			if(counter==capacity){
				cache.remove(leastRecent());
				cache.put(key, value);
			}else {
				counter++;
				cache.put(key, value);
			}
		}
    	queue.offer(key);
    }
 
    public int leastRecent() {
    	return queue.poll();
    }
    public static void main(String[] args) {
		LRUCache cache=new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		System.out.println(cache.get(2));
		cache.set(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
}
