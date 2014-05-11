package leetcode;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(muptiplySingle("999","2"));
		System.out.println(multiply("999","222"));
	}
	public static String multiply(String num1, String num2) {
		if(num1.length()<0 || num2.length()<0)
			return null;
		String aString;
		String bString;
		if(num1.length()>num2.length()){
			aString=num1;
			bString=num2;
		}else {
			aString=num2;
			bString=num1;
		}
		String result="0";
		for (int i = bString.length()-1; i >=0; i--) {
			String subResult=muptiplySingle(aString, bString.substring(i, i+1));
			for (int j = 0; j < bString.length()-1-i; j++) {
				subResult=subResult+"0";
			}
			result=plus(subResult, result);
		}
		return result;
    }
	private static String muptiplySingle(String num1, String num2) {
		String result="";
		int b=Integer.valueOf(num2);
		int carry=0;
		if(b<0 || b>9)
			return null;
		if(b==0)
			return "0";
		for (int i = num1.length()-1; i >=0; i--) {
			int a=Integer.valueOf(num1.charAt(i))-48;
			result=(a*b+carry)%10+result;
			carry=(a*b+carry)/10;
		}
		if(carry>0)
			result=carry+result;
		return result;
	}
	public static String plus(String num1, String num2) {
		String result="";
		int carry=0;
		String aString;
		String bString;
		if(num1.length()>num2.length()){
			aString=num1;
			bString=num2;
		}else {
			aString=num2;
			bString=num1;
		}
		int i=aString.length()-1;
		int diff=aString.length()-bString.length();
		while(i>=0){
			int a=Integer.valueOf(aString.charAt(i))-48;
			int b=i-diff>=0?Integer.valueOf(bString.charAt(i-diff))-48:0;
			result=(a+b+carry)%10+result;
			carry=(a+b+carry)/10;
			i--;
		}
		if(carry>0)
			result=carry+result;
		return result;
	}
}
