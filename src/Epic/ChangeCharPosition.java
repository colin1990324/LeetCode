package Epic;

import java.util.ArrayList;
import java.util.List;

/*
 * 给一个string， 里面不能有数字。 然后所有的大写字母和非字母符号不能动， 其他的小写字母可以随意动。 输出所有的可能。
 * e.g. input Oh my-god!
 * output Om hd-goy! Oy hm-dog! 等等。。
 */
public class ChangeCharPosition {

	public static void main(String[] args) {
		System.out.println(permutation("Oh my-god!"));
	}

	public static List<String> permutation(String s){
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0){
			return res;
		}
		StringBuilder path = new StringBuilder(s);
		List<Character> candidates = new ArrayList<Character>();
		List<Integer> position = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (Character.isLetter(c) && Character.isLowerCase(c)){
				candidates.add(c);
				position.add(i);
			}
		}
		boolean[] occurred = new boolean[candidates.size()];
		helper(res, path, candidates, position, occurred, 0);
		return res;
	}

	public static void helper(List<String> res, StringBuilder path, List<Character> candidates, List<Integer> position, boolean[] occurred, int index){
		if (index == position.size()){
			res.add(path.toString());
			return ;
		}
		for (int i = index; i < position.size(); i++){
			if (!occurred[i]) {
				occurred[i] = true;
				for (int j = 0; j < candidates.size(); j++) {
					path.setCharAt(position.get(i), candidates.get(j));
					char c = candidates.remove(j);
					helper(res, path, candidates, position, occurred, index + 1);
					candidates.add(j, c);
				}
				occurred[i] = false;
			}
		}
	}
}
