package interview;

/**
 * debugging 
 * binary search
 * @author ColinMac
 *
 */
public class SplunkOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {1,2,3,5,5};
		solution(A,5);
	}

	static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}
