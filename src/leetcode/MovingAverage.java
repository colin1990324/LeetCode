package leetcode;

/**
 * Given a set of data points:
 * data point    moving avg
 * 100.12           100.12
 * 99.87           (100.12+99.87) / 2
 * 95.76           (100.12+99.87+95.76) / 3
 * 94.98           (100.12+99.87+95.76+94.98) / 4
 * // consider millions of data points. 
 * Implement a MovingAverage class.  For example:
 * main() {
 * 	MovingAverage mv = new MovingAverage();
 *  mv.add(100.12);
 *  mv.add(99.87);
 *  mv.getAverage();    // (100.12+99.87) / 2
 * }
 */

public class MovingAverage {
	private int counter = 0;
	private double average = 0;
	private int counter2 = 0;
	private double average2 = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverage movingAverage = new MovingAverage();
		for (int i = 0; i < 100; i++) {
			// double nextDouble=random.nextDouble();
			double nextDouble = i;
			movingAverage.add(nextDouble);
			movingAverage.add2(nextDouble);
			System.out.println(movingAverage.getAverage() + " "
					+ movingAverage.getAverage2());
		}
		System.out.println(movingAverage.getAverage());
	}

	// normal
	public void add(double input) {
		average = (counter * average + input) / (counter + 1);
		counter++;
	}

	public double getAverage() {
		return average;
	}

	// handle huge mount of data
	public void add2(double input) {
		counter2++;
		double rate = (counter2 - 1.0) / counter2;
		average2 = average2 * rate + input / counter2;
	}

	public double getAverage2() {
		return average2;
	}
}
