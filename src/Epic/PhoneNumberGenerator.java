package Epic;

import java.util.ArrayList;
import java.util.List;

/*
 * 用0-9数字生成一个长度为N的电话号码,
 * (1) 号码不能用某三个数字 {a1, a2, a3},
 * (2) 号码当中4只能出现在首位,
 * (3)号码当中不能有任意两个连续的数字相同。
 * 求print出所有可能的号码。
 */

public class PhoneNumberGenerator {

	public static void main(String[] args) {
		ArrayList<Integer> baned = new ArrayList<Integer>();
		baned.add(1);
		baned.add(2);
		baned.add(3);
		baned.add(5);
		baned.add(7);
		baned.add(8);
		baned.add(9);
		System.out.println(generateNumber(3,baned));
	}

    public static List<List<Integer>> generateNumber (int length, List<Integer> baned){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++){
            if (!baned.contains(i)){
                candidates.add(i);
            }
        }
        List<Integer> path = new ArrayList<Integer>();
        helper(res, path, candidates, length);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> path, List<Integer> candidates, int length){
        if (path.size() == length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < candidates.size(); i++){
            int digit = candidates.get(i);
            if (path.size()>0){
                if (path.get(path.size()-1) == digit){
                    continue;
                }
            }
            if (digit == 4 && path.size()>0){
                continue;
            }
            path.add(digit);
            helper(res, path, candidates, length);
            path.remove((path.size()-1));
        }
    }
}
