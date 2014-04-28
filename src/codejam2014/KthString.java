package codejam2014;

public class KthString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kString(4, 7, 47));
	}
	//http://www.coderblog.cn/View/20/%E5%BE%AE%E8%BD%AF%E7%AC%94%E8%AF%95%E9%A2%98%EF%BC%9AK-th%20string/
	//N '0's, M '1's, K is target
	public static String kString(int N,int M, int K) {
		String max="";
		for (int i = 0; i < M; i++) {
			max+="1";
		}
		for (int i = 0; i < N; i++) {
			max+="0";
		}
		String min="";
		for (int i = 0; i < N; i++) {
			min+="0";
		}
		for (int i = 0; i < M; i++) {
			min+="1";
		}
		int counter=1;
		String result=min;
		while(counter<K){
			result=next(result);
			System.out.println(result);
			counter++;
			if(result==null)
				return "Impossible";
			if(result.equals(max) && counter!=K)
				return "Impossible";
		}
		return result;
	}
	private static String next(String string) {
		int index=string.lastIndexOf("01");
		if(index==-1)
			return null;
		char[] chars=string.toCharArray();
		chars[index]='1';
		chars[index+1]='0';
		return String.valueOf(chars);
	}
}
