
public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arrayA = { 1,2,4};
//		int[] arrayB = {1,5};
//		printIntArray(arrayA);
//		printIntArray(arrayB);
//		printIntArray(mergeInt(arrayA, arrayA.length, arrayB, arrayB.length));
		int[] arrayC =new int[5];
		arrayC[0]=1;
		arrayC[1]=2;
		arrayC[2]=4;
		int[] arrayD = {2,5};
		new MergeSortedArray().merge(arrayC, 3, arrayD, arrayD.length);
		printIntArray(arrayC);
	}
	public void merge(int A[], int m, int B[], int n) {
		//if input has empty array
        if(m==0){
        	for(int i=0;i<n;i++){
        		A[i]=B[i];
        	}
        	return;
        }else if(n==0){
        	return;
        }
        //merge
        for(int i=m-1;i>=0;i--){
    		A[i+n]=A[i];
    	}
        int pointerA=n;
        int pointerB=0;
        for(int i=0;i<m+n;i++){
        	if(A[pointerA]<=B[pointerB]){
        		A[i]=A[pointerA];
        		pointerA++;
        	}else{
        		A[i]=B[pointerB];
        		pointerB++;
        	}
        	if(pointerA>=m+n){
        		do{
        			i++;
        			A[i]=B[pointerB];
        			pointerB++;
        		}while(pointerB<n);
        		return;
        	}
        	if(pointerB>=n){
        		return;
        	}
        }
    }
	public static int[] mergeInt(int A[], int m, int B[], int n) {
		//if input has empty array
        if(m==0){
        	return B;
        }else if(n==0){
        	return A;
        }
        //merge
        int[] array=new int[m+n];
        int pointerA=0;
        int pointerB=0;
        for(int i=0;i<m+n;i++){
        	if(A[pointerA]<=B[pointerB]){
        		array[i]=A[pointerA];
        		pointerA++;
        	}else{
        		array[i]=B[pointerB];
        		pointerB++;
        	}
        	if(pointerA>=m){
        		do{
        			i++;
        			array[i]=B[pointerB];
        			pointerB++;
        		}while(pointerB<n);
        		return array;
        	}
        	if(pointerB>=n){
        		do{
        			i++;
        			array[i]=A[pointerA];
        			pointerA++;
        		}while(pointerA<n);
        		return array;
        	}
        }
		return array;
    }
	public static void printIntArray(int[] array) {
		System.out.print("{ ");
		for(int i=0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("}");
	}
}
