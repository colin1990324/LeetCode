package leetcode;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,2,0};
		int[] B={3,4,-1,1};
		System.out.println("should be 3, result="+firstMissingPositive(A));
		System.out.println("should be 2, result="+firstMissingPositive(B));
	}
	public static int firstMissingPositive(int[] A) {
		if (A.length == 0) return 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= A.length && A[i] > 0 && A[i] != i+1) {
                if (A[A[i]-1] != A[i]) { //line 9
                    int tmp = A[A[i]-1];
                    A[A[i]-1] = A[i];
                    A[i] = tmp;
                    i--; //line 13
                }
            }            
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) return i+1;
        }
        return A.length+1;
    }
}
