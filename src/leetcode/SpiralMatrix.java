package leetcode;
import java.util.ArrayList;
import java.util.Iterator;


public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix=Matrix.intMatrix(1, 1);
		Matrix.printMatrix(matrix);
		ArrayList<Integer> array=new SpiralMatrix().spiralOrder(matrix);
		String string="[ ";
		Iterator<Integer> iterator=array.iterator();
		while (iterator.hasNext()) {
			string+=iterator.next()+" ,";
		}
		string.substring(0,string.length()-2);
		System.out.println(string+" ]");
	}
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		if (matrix==null) {
			return null;
		}
		int upWall = -1;
		int leftWall=-1;
		int downWall=matrix.length;
		if (matrix.length==0) {
			return new ArrayList<Integer>();
		}
		int rightWall=matrix[0].length;
		int direction=1;
		int m=0;
		int n=0;
		int counter=0;
		ArrayList<Integer> array=new ArrayList<Integer>();
		while(counter<matrix.length*matrix[0].length){
			//System.out.println(matrix[m][n]);
			array.add(matrix[m][n]);
			counter++;
			if(direction==1){
				if(n+1==rightWall){
					direction++;
					m++;
					upWall++;
				}else {
					n++;
				}
			}else if(direction==2){
				if(m+1==downWall){
					direction++;
					n--;
					rightWall--;
				}else {
					m++;
				}
			}else if(direction==3){
				if(n-1==leftWall){
					direction++;
					m--;
					downWall--;
				}else {
					n--;
				}
			}else if(direction==4){
				if(m-1==upWall){
					direction=1;
					n++;
					leftWall++;
				}else {
					m--;
				}
			}
		}
		return array;
    }
	
}