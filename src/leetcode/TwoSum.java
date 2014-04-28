package leetcode;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers={3,2,4};
		int[] result=twoSum(numbers, 6);
		System.out.println(result[0]+" "+result[1]);
	}
	//http://oj.leetcode.com/problems/two-sum/
	public static int[] twoSum(int[] numbers, int target) {
		//in HashMap
        //key is integer in numbers[]
        //value is index of key integer in numbers[]
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int[] result=new int[2];
        for(int i=0;i<numbers.length;i++) {
			if(map.containsKey(target-numbers[i])){
				result[0]=map.get(target-numbers[i])+1;
				result[1]=i+1;
				return result;
			}else{
				map.put(numbers[i], i);
			}
		}
        return null;
    }
}
