
public class Matrix {

	public static int[][] intMatrix(int m, int n) {
		int[][] matrix=new int[m][n];
		int counter=1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j]=counter;
				counter++;
			}
		}
		return matrix;
	}
	public static void printMatrix(int[][] matrix){
		System.out.println("[");
		for (int i = 0; i < matrix.length; i++) {
			String string=" [ ";
			for (int j = 0; j < matrix[i].length; j++) {
				string+=matrix[i][j];
				string+=", ";
			}
			string.substring(0, string.length()-2);
			string+="],";
			System.out.println(string);
		}
		System.out.println("]");
	}
}
