package leetcode;
public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int sum = 0;
		for (int i = 0; i < gas.length; i++) {
			int dif = gas[i] - cost[i];

			if (sum < 0) {
				start = i;
				sum = 0;
			}
			sum += dif;
		}
		if (sum < 0)
			return -1;
		for (int i = 0; i < start; i++)
			sum += gas[i] - cost[i];
		if (sum >= 0)
			return start;
		else
			return -1;
	}
}
