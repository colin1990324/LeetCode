package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("result for 1110201: "+longestPalindrome("1110201"));
		System.out.println("result for bb: "+longestPalindrome("bb"));
	}
	//http://oj.leetcode.com/problems/longest-palindromic-substring/
	public static String longestPalindrome(String s) {
        int length=s.length();
        if(length==0)
        	return "";
        float bestMid=0;
        float maxRange=1;
        for (int i = 0; i < length; i++) {
        	//i is middle
			float mid=i;
			float j=1;
			while (mid-j>=0 && mid+j<length) {
				if(s.charAt((int) (mid-j))!=s.charAt((int) (mid+j))){
					break;
				}
				j++;
			}
			if(j>maxRange){
				maxRange=j;
				bestMid=mid;
			}
			//i and i+1 are middle
			mid=0.5f+i;
			j=0.5f;
			while (mid-j>=0 && mid+j<length) {
				if(s.charAt((int) (mid-j))!=s.charAt((int) (mid+j))){
					break;
				}
				j++;
			}
			if(j>maxRange){
				maxRange=j;
				bestMid=mid;
			}
		}
        return s.substring((int)(bestMid-maxRange+1), (int)(bestMid+maxRange));
    }
}
