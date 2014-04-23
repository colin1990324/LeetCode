package leetcode;

public class MyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="007799aabbccddeeff113355zz";
		String string2="abcdefabcdefabcdefaaaaaaaaaaaaaabbbbbbbddddddee";
		System.out.println(reorder(string2));
	}
	//http://www.coderblog.cn/View/18/%E5%BE%AE%E8%BD%AF%E7%AC%94%E8%AF%95%E9%A2%98%EF%BC%9AString%20reorder/
	public static String reorder(String in) {
		//0-25: a-z
		//26-35:0-9
		int[] counter=new int[36];
		int sum=0;
		char[] chars=in.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c=chars[i];
			if(c<97)
				counter[c-22]++;
			else
				counter[c-97]++;
			sum++;
		}
		String output="";
		while (sum>0) {
			for (int i = 26; i < 36; i++) {
				if(counter[i]>0){
					output+=(char)(i+22);
					counter[i]--;
					sum--;
				}
			}
			for (int i = 0; i < 26; i++) {
				if(counter[i]>0){
					output+=(char)(i+97);
					counter[i]--;
					sum--;
				}
			}
		}
		return output;
	}
}
