package Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 电池有6节包装，9节包装，20节包装三种，input需要多少节电池，如果可以刚好用3种包装的凑到这个数，就输出这个解， 
 * 忘了是不是要输出所有的解。
 * e.g 输入20， 答{20} 输入17 答没有 输入18，那可能是{6,6,6}也可能是{9,9}。 
 * 有点像找钱的问题，似乎是从集合中找到所有集合值等于一个target这个题的简化版，因为集合只有6 9 20。
 */
public class Batteries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static List<List<Integer>> combinationSum(int[] num, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0){
            return res;
        }
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(res, path, num, target);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> path, int[] num, int target){
        if (target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        else if (target < 0){
            return;
        }
        else{
            for (int i = 0; i < num.length; i++){
                path.add(num[i]);
                helper(res, path, num, target-num[i]);
                path.remove(path.size()-1);
            }
        }
    }
    
    /*
     * Min combination
     * DP
     */
    
    public static int combinationSumDP(int[] num, int target){
        if (num == null || num.length == 0){
            return 0;
        }
        if (target == 0){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < num.length;j++){
                if (num[j] <= i && dp[i-num[j]]+1 < dp[i]){
                    dp[i] = dp[i-num[j]]+1;
                }
            }
        }
        return dp[target];
    }
}
