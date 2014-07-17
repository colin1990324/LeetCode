package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("hoo");
		String start = "hit";
		String end = "aaa";
		System.out.println(ladderLength(start, end, dict));
	}

	public static int ladderLength(String start, String end,
			HashSet<String> dict) {
		dict.add(end);
		HashSet<String> exit = new HashSet<String>();
		exit.add(start);
		int result = subLength(start, end, dict, exit);
		if (result == Integer.MAX_VALUE - 1)
			return 0;
		return result;
	}

	public static int subLength(String start, String end, HashSet<String> dict,
			HashSet<String> exit) {
		int transformCounter = Integer.MAX_VALUE - 1;
		Iterator<String> iterator = getNextLocal(start, dict, exit).iterator();
		while (iterator.hasNext()) {
			String tmpString = iterator.next();
			if (tmpString.equals(end))
				return 2;
			else {
				exit.add(tmpString);
				transformCounter = Math.min(
						subLength(tmpString, end, dict, exit) + 1,
						transformCounter);
			}
		}
		return transformCounter;
	}

	// return all possible next nodes(no overlap)
	public static HashSet<String> getNext(String string, HashSet<String> dict,
			HashSet<String> exit) {
		HashSet<String> strings = new HashSet<String>();
		Iterator<String> iterator = dict.iterator();
		while (iterator.hasNext()) {
			String tmp = iterator.next();
			if (exit.contains(tmp))
				continue;
			if (isNext(string, tmp))
				strings.add(tmp);
		}
		return strings;
	}

	// return all possible next nodes(by local transform)
	// create and delete(not in dictionary and in exit)
	public static HashSet<String> getNextLocal(String string,
			HashSet<String> dict, HashSet<String> exit) {
		HashSet<String> strings = new HashSet<String>();
		for (int i = 0; i < string.length(); i++) {
			char[] s = string.toCharArray();
			// 'a'=97,'z'=122
			for (int j = 97; j < 123; j++) {
				s[i] = (char) j;
				strings.add(String.valueOf(s));
			}
		}
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			String tmp = iterator.next();
			if (exit.contains(tmp)) {
				iterator.remove();
				continue;
			}
			if (!dict.contains(tmp))
				iterator.remove();
		}
		return strings;
	}

	// if string can transform to dictS, return true
	// transform means only one letter different. same length String.
	public static boolean isNext(String string, String dictS) {
		if (string.length() != dictS.length())
			return false;
		char[] charA = string.toCharArray();
		char[] charB = dictS.toCharArray();
		int counter = 0;
		for (int i = 0; i < string.length(); i++) {
			if (charA[i] != charB[i]) {
				counter++;
			}
		}
		if (counter == 1)
			return true;
		return false;
	}

	// http://answer.ninechapter.com/solutions/word-ladder/
	// BFS. Key is remove researched words from the dictionary.
	public int ladderLengthII(String start, String end, HashSet<String> dict) {
		if (dict == null || dict.size() == 0) {
			return 0;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int length = 1;

		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				String current = queue.poll();
				for (char c = 'a'; c <= 'z'; c++) {
					for (int j = 0; j < current.length(); j++) {
						if (c == current.charAt(j)) {
							continue;
						}
						String tmp = replace(current, j, c);
						if (tmp.equals(end)) {
							return length + 1;
						}
						if (dict.contains(tmp)) {
							queue.offer(tmp);
							dict.remove(tmp);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}

	private String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);
	}

	// find all shortest transformation sequence(s) from start to end
	ArrayList<ArrayList<String>> answer;

	private class Node{
		public String val;
		public int no;
		public ArrayList<Node> prev;
		Node(int no, String val){
			this.val=val;
			this.no=no;
			prev = new ArrayList<Node>();
		}
		public void addPrev(Node no){
			prev.add(no);
		}
	}
	
    public void findPath(Node node, ArrayList<String> cur, String start) {
        if (node.val.equals(start)) {
            answer.add(cur);
            return;
        }
        ArrayList<String> temp;
        for (Node n : node.prev) {
            temp = new ArrayList<String>(cur);
            temp.add(0, n.val);
            findPath(n, temp, start);
        }
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, Node> map = new HashMap<String, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        Node node = new Node(0, start);
        Node endNode = null;
        map.put(start, node);
        queue.add(node);
        boolean stop = false;
        while (queue.size() > 0 && !stop) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                node = queue.poll();
                for (int j = 0; j < node.val.length(); j++) {
                    StringBuilder t = new StringBuilder(node.val);
                    for (char k = 'a'; k <= 'z'; k++) {
                        t.setCharAt(j, k);
                        if (dict.contains(t.toString())) {
                            Node v = map.get(t.toString());
                            if (v == null) {
                                Node temp = new Node(node.no + 1, t.toString());
                                temp.addPrev(node);
                                queue.add(temp);
                                map.put(t.toString(), temp);
                                if (t.toString().equals(end)) {
                                    endNode = temp;
                                    stop = true;
                                }
                            }
                            else {
                                if (v.no == node.no + 1) {
                                    v.addPrev(node);
                                }
                            }
                        }
                    }
                }
            }
        }
        answer = new ArrayList<ArrayList<String>>();
        if (endNode != null) {
            findPath(endNode, new ArrayList<String>(Arrays.asList(end)), start);
        }
        return answer;
    }
}
