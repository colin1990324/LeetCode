package leetcode;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="a";
		String s2="b";
		String s3 = "aba";
		System.out.print(isInterleave(s1, s2, s3));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length()!=s1.length()+s2.length())
			return false;
		if(s1.equals(""))
			return s2.equals(s3);
		if(s2.equals(""))
			return s1.equals(s3);
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		boolean[][] matrix=new boolean[s1.length()+1][s2.length()+1];
		matrix[0][0]=true;
		for (int i = 1; i < s2.length()+1; i++) {
			if(matrix[0][i-1] && c2[i-1]==s3.charAt(i-1))
				matrix[0][i]=true;
		}
		for (int i = 1; i < s1.length()+1; i++) {
			if(matrix[i-1][0] && c1[i-1]==s3.charAt(i-1))
				matrix[i][0]=true;
		}
		for (int i = 1; i < s1.length()+1; i++) {
			for (int j = 1; j <s2.length()+1; j++) {
				//go right, take a char from c2
				if(matrix[i][j-1] && s3.charAt(i+j-1)==c2[j-1])
					matrix[i][j]=true;
				//go down, take a char from c1
				if(matrix[i-1][j] && s3.charAt(i+j-1)==c1[i-1])
					matrix[i][j]=true;
			}
		}
		return matrix[s1.length()][s2.length()];
    }
}
