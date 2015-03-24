package interview;

/*
 * cutting a chain into three pieces
 */
public class SplunkOne3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplunkOne3 s = new SplunkOne3();
		int[] A= {7, 3, 1, 2, 6, 7};
		s.solution(A);
	}

	int min1=Integer.MAX_VALUE;
    int min2=Integer.MAX_VALUE;
    int min3=Integer.MAX_VALUE;
    int index1=1;
    int index2=1;
    int index3=1;
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        for(int i = 1; i < A.length -1; i++){
            maintain(A[i],i);
        }
        if(Math.abs(index1-index2)!=1)
            return A[index1]+A[index2];
        else if(Math.abs(index1-index3)!=1)
            return A[index1]+A[index3];
        else
            return A[index2]+A[index3];
    }
    
    // maintain Minimums
    private void maintain(int a, int index){
        if(a<min1){
        	min3=min2;
        	index3=index2;
        	min2=min1;
        	index2=index1;
            min1=a;
            index1=index;
            return;
        }else if(a<min2){
        	min3=min2;
        	index3=index2;
            min2=a;
            index2=index;
            return;
        }else if(a<min3){
            min3=a;
            index3=index;
        }   
    }
}
