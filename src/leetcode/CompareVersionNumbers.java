package leetcode;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("0", "1"));
		System.out.println(compareVersion("1.0", "1.0"));
		System.out.println(compareVersion("1.0", "1.1"));
		System.out.println(compareVersion("1.0", "0.1"));
		System.out.println(compareVersion("1.0", "1.0.1"));
		System.out.println(compareVersion("1.06", "1.6"));
		System.out.println(compareVersion("1.6", "1.10"));
		System.out.println(compareVersion("1.9.9.9", "1.10.0.0"));
	}

	public static int compareVersion(String version1, String version2) {
		String[] ss1 = version1.split("\\.");
		String[] ss2 = version2.split("\\.");
		if (ss1.length < 3 && ss2.length < 3) {
			return compareFloat(Float.valueOf(version1),
					Float.valueOf(version2));
		} else if (ss1.length < 3) {
			int i = compareFloat(Float.valueOf(version1),
					Float.valueOf(ss2[0] + "." + ss2[1]));
			if (i != 0)
				return i;
			else
				return -1;
		} else if (ss2.length < 3) {
			int i = compareFloat(Float.valueOf(ss1[0] + "." + ss1[1]),
					Float.valueOf(version2));
			if (i != 0)
				return i;
			else
				return 1;
		}
		int i = compareFloat(Float.valueOf(ss1[0] + "." + ss1[1]),
				Float.valueOf(ss2[0] + "." + ss2[1]));
		if (i != 0)
			return i;
		return compareVersion(version1.substring(ss1[0].length()),
				version2.substring(ss2[0].length()));
	}

	public static int compareFloat(float version1, float version2) {
		if (version1 > version2)
			return 1;
		else if (version1 < version2)
			return -1;
		return 0;
	}

	// in this case, 1.2 is bigger than 1.10
	public static int compareVersion2(String version1, String version2) {
		int index1 = version1.indexOf(".") > 0 ? version1.indexOf(".")
				: version1.length();
		int index2 = version2.indexOf(".") > 0 ? version2.indexOf(".")
				: version2.length();
		int n1 = Integer.valueOf(version1.substring(0, index1));
		int n2 = Integer.valueOf(version2.substring(0, index2));
		if (n1 > n2)
			return 1;
		if (n1 < n2)
			return -1;
		index1++;
		index2++;
		while (index1 < version1.length() && index2 < version2.length()) {
			if (version1.charAt(index1) == '.') {
				if (version2.charAt(index2) != '.')
					return -1;
				else {
					index1++;
					index2++;
				}
			} else {
				if (version2.charAt(index2) == '.')
					return 1;
				else if (version1.charAt(index1) == version2.charAt(index2)) {
					index1++;
					index2++;
				} else if (version1.charAt(index1) > version2.charAt(index2))
					return 1;
				else
					return -1;
			}
		}
		if (index1 < version1.length())
			return 1;
		if (index2 < version2.length())
			return -1;
		return 0;
	}
}
