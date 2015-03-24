package leetcode;

public class Numberof1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numberof1Bits n = new Numberof1Bits();
		n.hammingWeight(Integer.valueOf("10000000000000000000000000000000",2));
	}

	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n==0)
            return 0;
        if((n&1)==1)
            return 1+hammingWeight(n>>>1);
        else
            return hammingWeight(n>>>1);
    }
    // you need to treat n as normal int
    public int hammingWeight2(int n) {
        if(n<0)
            return 1+hammingWeight2(Integer.MAX_VALUE+n);
        if(n==0)
            return 0;
        if(n%2==1)
            return 1+hammingWeight2(n/2);
        else
            return hammingWeight2(n/2);
        
    }

}
