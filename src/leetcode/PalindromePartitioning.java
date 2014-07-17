package leetcode;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(partition("ADDA"));
		System.out.println(partition("ADaDA"));
		System.out.println(partition("AAaD"));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> lists = new ArrayList<List<String>>();
		List<String> currentList = new ArrayList<String>();
		partition(s, lists, currentList);
		return lists;
	}
	
	public static void partition(String s, List<List<String>> lists, List<String> currentList) {
		if(s.length()==0)
			lists.add(currentList);
		for(int i=0;i<s.length();i++){
			String subString = s.substring(0,i+1);
			if(isPalidrome(subString)){
				List<String> newList = new ArrayList<String>(currentList);
				newList.add(subString);
				partition(s.substring(i+1), lists, newList);
			}
		}
	}

	public static boolean isPalidrome(String s) {
		int length = s.length();
		if (length == 1)
			return true;
		for (int i = 0; i < length / 2; i++) {
			if (s.charAt(i) != s.charAt(length - i - 1))
				return false;
		}
		return true;
	}
}
