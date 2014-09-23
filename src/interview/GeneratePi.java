package interview;

import java.util.Random;

public class GeneratePi {
	private static double a =0;
	private static double b=0;
	private static double best=3.14;
	public static void main(String[] args) {
		find();
	}
	public static double generatePi(){
		Random random = new Random();
		for(int i =0;i<100000;i++){
			double x = random.nextDouble();
			double y = random.nextDouble();
			if(x*x+y*y<=1)
				a++;
			b++;
		}
		return a/b*4;
	}
	public static void find(){
		double a = 245850922;
		while(Math.abs(Math.PI-best)>Math.pow(10, -14)){
			double b = a/Math.PI;
			if(isBest(a/Math.floor(b)))
				System.out.println(a + " " + Math.floor(b));
			if(isBest(a/Math.ceil(b)))
				System.out.println(a+" "+Math.ceil(b));
			a++;
		}
	}
	public static boolean isBest(double value){
		if(Math.abs(Math.PI-value)<Math.abs(Math.PI-best)){
			best=value;
			return true;
		}
		return false;
	}
}
