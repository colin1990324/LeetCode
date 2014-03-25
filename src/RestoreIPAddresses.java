import java.util.ArrayList;
import java.util.Iterator;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "010010";
		Iterator<String> iterator = restoreIpAddresses(input).iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}

	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> output = new ArrayList<String>();
		int length = s.length();
		if(length>12)
			return output;
		for (int i = 0; i < length - 3; i++) {
			for (int j = i + 1; j < length - 2; j++) {
				for (int j2 = j + 1; j2 < length - 1; j2++) {
					String newString = s.subSequence(0, i + 1) + "."
							+ s.substring(i + 1, j + 1) + "."
							+ s.substring(j + 1, j2 + 1) + "."
							+ s.substring(j2 + 1);
					if (isIPAddresses(newString))
						output.add(newString);
				}
			}
		}
		return output;
	}

	public static boolean isIPAddresses(String input) {
		String[] array = input.split("\\.");
		if (array.length != 4)
			return false;
		else {
			for (int i = 0; i < 4; i++) {
				if (array[i].length() > 3)
					return false;
				if(array[i].startsWith("0") && array[i].length()>1)
					return false;
				int x = Integer.valueOf(array[i]);
				if (x >= 0 && x <= 255)
					continue;
				else
					return false;
			}
		}
		return true;
	}
}
