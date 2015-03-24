package Epic;

/*
 * greatest possible sum: 
 * 给你几个数 eg：5，0，-123，19，-1找出 greatest possible sum 5+0+19+（-1）=23 
 * 这个sum要在 subsequence里面找，subsequence是至少有两个数。
 */
public class GreatPossibleSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Brutal
	 */
	public class Solution {
	    public int maxSubArray(int[] A) {
	        int len = A.length;
	        int max = Integer.MIN_VALUE;

	        for (int i = 0; i < len; i++){
	            int sum = 0;
	            for (int j = i; j < len; j++){
	                sum += A[j];
	                if (sum > max){
	                    max = sum;
	                }
	            }
	        }
	        return max;
	    }
	}
	
	/*
	 * O(n)
	 */
    public int maxSubArray(int[] A) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndHere = 0;
        for (int i = 0; i < A.length; i++){
            if (maxEndHere < 0){
                maxEndHere = 0;
            }
            maxEndHere += A[i];
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
    
    /*
     * sub-array should contain at least 2 number 
     */
    int[] solution(int[] n){
		if(n.length < 2)
			return null;
		if(n.length == 2)
			return n;

		int maxStart = 0;
		int maxEnd = 1;
		int maxHereStart = 0;
		int maxHereEnd = 1;
		int max_ending_here = n[0] + n[1];
		int max_so_far = max_ending_here;
		for(int i = 2; i < n.length ; i ++){
			if(n[i]+n[i-1] > (max_ending_here + n[i]))
			{
				max_ending_here = n[i]+n[i-1];
				maxHereEnd = i;
				maxHereStart = i-1;
			}else
			{
				max_ending_here = max_ending_here + n[i];
				maxHereEnd = i;
			}
			if(max_ending_here > max_so_far){
				max_so_far = max_ending_here;
				maxStart = maxHereStart;
				maxEnd = maxHereEnd;
			}
		}

		int[] result = new int[maxEnd - maxStart+1];
		for(int k = 0; k<= (maxEnd-maxStart); k++){
			result[k] = n[k+maxStart];
		} 
		return result;
	}
}
