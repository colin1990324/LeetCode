package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://oj.leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
		generateParenthesis("",0,0,n,list);
		return list;
	}
	
	private static void generateParenthesis(String s, int left, int right, int n, ArrayList<String> list){
		if(n==0)
			return;
		if(left==right && right == n){
			list.add(s);
			return;
		}
		
		if(left<n)
			generateParenthesis(s+"(",left+1,right,n,list);
		if(right<left)
			generateParenthesis(s+")",left,right+1,n,list);
	}
}
