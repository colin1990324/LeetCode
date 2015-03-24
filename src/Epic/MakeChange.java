package Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 找钱问题， 不过是简化版的。 
 * 就是输入最多是10块钱， 东西最贵是1块钱， 有5块1块25c 10c 5c和1c的，输出找钱的组合。 
 * 不过只要求输出一种，就是有大的用大的那种。相对就简单很多了。
 * e.g. 付了10块，东西1c, 找1张5 4张1 3个quarter 2个dime 4个pennies
 */
public class MakeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<List<Integer>> CoinChange(int[] coins, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (coins == null || coins.length == 0) {
			return res;
		}
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(coins);
		helper(res, path, coins, target);
		return res;
	}

	public static void helper(List<List<Integer>> res, List<Integer> path,
			int[] coins, int target) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(path));
			return;
		} else if (target < 0) {
			return;
		} else {
			for (int i = 0; i < coins.length; i++) {
				path.add(coins[i]);
				helper(res, path, coins, target - coins[i]);
				path.remove(path.size() - 1);
			}
		}
	}

	/*
	 * Ways
	 */
	public static int makeChange(int amount, int[] denoms, int index) {
		if (index >= denoms.length - 1) {
			return 1;
		}
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1);
		}
		return ways;
	}
	
	/*
	 * DP version
	 */
    public static int makeChange(int n){
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n+1][denoms.length];
        return helper(n, denoms, map, 0);
    }

    public static int helper(int amount, int[] denoms, int[][] map, int index){
        if (map[amount][index] > 0){
            return map[amount][index];
        }
        if (index >= denoms.length-1){
            return 1;
        }
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++){
            int amountRemaining = amount-i*denomAmount;
            ways += helper(amountRemaining, denoms, map, index+1);
        }
        map[amount][index] = ways;
        return ways;
    }
}
