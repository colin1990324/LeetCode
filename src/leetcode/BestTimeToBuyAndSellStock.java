package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 3, 7, 5, 2, 6 };
		System.out.println(maxProfitIII(prices));
	}

	// only one buy and sale
	public static int maxProfit(int[] prices) {
		int length = prices.length;
		if (length < 2)
			return 0;
		ArrayList<Integer> inflexion = new ArrayList<Integer>();
		inflexion.add(prices[0]);
		int index = 0;
		while (index != length - 1) {
			while (index != length - 1 && prices[index] >= prices[index + 1])
				index++;
			inflexion.add(prices[index]);
			while (index != length - 1 && prices[index] <= prices[index + 1])
				index++;
			inflexion.add(prices[index]);
		}
		int profit = 0;
		length = inflexion.size();
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (inflexion.get(j) - inflexion.get(i) > profit)
					profit = inflexion.get(j) - inflexion.get(i);
			}
		}
		return profit;
	}

	// eveyday one operation
	public static int maxProfitII(int[] prices) {
		int length = prices.length;
		if (length == 0)
			return 0;
		int index = 0;
		while (index != length - 1 && prices[index] >= prices[index + 1])
			index++;
		int low = prices[index];
		while (index != length - 1 && prices[index] <= prices[index + 1])
			index++;
		int high = prices[index];
		int profit = high - low;
		if (index != length - 1)
			profit += maxProfit(Arrays.copyOfRange(prices, index, length));
		return profit;
	}

	// only two buy and sale
	public static int maxProfitIII(int[] prices) {
		int length = prices.length;
		if (length < 2)
			return 0;
		ArrayList<Integer> inflexion = new ArrayList<Integer>();
		inflexion.add(prices[0]);
		int index = 0;
		while (index != length - 1) {
			while (index != length - 1 && prices[index] >= prices[index + 1])
				index++;
			inflexion.add(prices[index]);
			while (index != length - 1 && prices[index] <= prices[index + 1])
				index++;
			inflexion.add(prices[index]);
		}
		if (inflexion.get(0) == inflexion.get(1))
			inflexion.remove(0);
		int profit = 0;
		length = inflexion.size();
		for (int i = 0; i < length - 1; i++) {
			int p = maxProfit(inflexion.subList(0, i))
					+ maxProfit(inflexion.subList(i, length));
			if (p > profit)
				profit = p;
		}
		return profit;
	}

	public static int maxProfit(List<Integer> inflexion) {
		int profit = 0;
		int length = inflexion.size();
		if (length < 2)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < length; i++) {
			if (inflexion.get(i) < min) {
				min = inflexion.get(i);
				max = 0;
			} else if (inflexion.get(i) > max) {
				max = inflexion.get(i);
				if (profit < max - min)
					profit = max - min;
			}
		}
		return profit;
	}
}
