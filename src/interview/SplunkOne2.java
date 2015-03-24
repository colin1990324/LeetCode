package interview;

/*
 * swap two elements to make the array non-decreasing
 */
public class SplunkOne2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean solution(int[] A) {
		// write your code in Java SE 8
		if (isNonDec(A))
			return true;
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int first = A[i];
				int second = A[j];
				A[i] = second;
				A[j] = first;
				if (isNonDec(A))
					return true;
				A[i] = first;
				A[j] = second;
			}
		}
		return false;
	}

	public boolean isNonDec(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1])
				return false;
		}
		return true;
	}

}
