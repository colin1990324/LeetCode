package Epic;

/*
 * 给一个string，不算非字母项，每个word长度凡是有>=4并且为偶数的，拆成两半放回去输出。
 */
public class FoldString {

	public static void main(String[] args) {
		System.out.println(fold("sdfafa fafsfds fa"));
	}

    public static String fold(String s){
        StringBuffer res = new StringBuffer(s);
        int i = 0;
        while (i < res.length()){
            while (i < res.length() && res.charAt(i) == ' '){  //跳过leading space
                i++;
            }
            int j = i;
            while (j < res.length() && Character.isLetter(res.charAt(j))){
                j++;
            }
            if (j-i >= 4 && (j-i)%2 == 0){
                int mid = (i+j)/2;
                res.insert(mid, ' ');
                i = j+1;
            }
            else {
                i = j;
            }
        }
        return res.toString();
    }
}
