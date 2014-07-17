package leetcode;
public class Candy {

	public static void main(String[] args) {
		int[] ratings = { 1, 2, 2 };
		System.out.println(candy(ratings));
	}

	public static int candy(int[] ratings) {
		int[] candy = new int[ratings.length];
		// allocate candies, considering the minimal rating on the left
		candy[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
		}
		// modify the allocation, considering the minimal rating on the right
		int totalCandy = candy[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			candy[i] = (ratings[i] > ratings[i + 1] && candy[i + 1] + 1 > candy[i]) ? candy[i + 1] + 1
					: candy[i];
			// count total candies by the way
			totalCandy += candy[i];
		}
		return totalCandy;
	}
}
