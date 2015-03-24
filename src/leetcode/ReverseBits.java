package leetcode;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -1;
		ReverseBits r = new ReverseBits();
		System.out.println(Integer.toBinaryString(r.reverseBits(n)));
		System.out.println(Integer.toBinaryString(n));
	}

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int r = 0;
		for (int i = 0; i < 32; i++) {
			r = (r << 1) + ((n >> i) & 1);
		}
		return r;
	}
	
	

}
