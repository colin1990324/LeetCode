package leetcode;
public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "";
		System.out.print(reverseWords(string));
		System.out.print("#end");
	}

	public static String reverseWords(String s) {
		String[] arrayStrings = s.split(" ");
		String result = "";
		for (int i = 0; i < arrayStrings.length; i++) {
			if (!arrayStrings[i].equals(""))
				result = arrayStrings[i] + " " + result;
		}
		if (result.equals(""))
			return result;
		else if (result.substring(result.length() - 1).equals(" "))
			return result.substring(0, result.length() - 1);
		else
			return result;
	}
}
