package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Refection {

	int m;
	int n;
	ArrayList<Coin> list = new ArrayList<Coin>();
	HashSet<Pair> set = new HashSet<Pair>();

	class Coin {
		int x;
		int y;
		int value;

		Coin(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	class Reflect {
		Coin c;
		Direc d;

		Reflect(Coin c, Direc d) {
			this.c = c;
			this.d = d;
		}
	}

	class Pair{
		int x;
		int y;
		Direc d;
		Pair(int x,int y,Direc d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
		public boolean equals(Pair p){
	        if(x==p.x && y==p.y && d==p.d)
	        	return true;
	        return false;
	    }

	    public int hashCode(){
	      int res=5;
	      res = res*1000 + x;
	      res = res*1000 + y;
	      return res;
	    }
	}
	
	public enum Direc {
		UP, UP_R, UP_L, R, L, DOWN_R, DOWN, DOWN_L;
		public Direc getReflect(int x, int y, int m, int n, Direc d){
			return UP;
		}
	}

	public static void main(String[] args) {

	}

	public int solver() {
		m = 6;
		n = 6;
		int n = 4;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < n; i++) {
			try {
				String s = br.readLine();
				if (s.length() == 0)
					break;
				String[] ss = s.split(" ");
				list.add(new Coin(Integer.valueOf(ss[0]), Integer
						.valueOf(ss[1]), Integer.valueOf(ss[2])));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int maxValue = 0;
		int value=0;
		//horizontal
		for(int i=0;i<m;i++){
			value=0;
			for(Coin c:list){
				if(c.x==m)
					value+=c.value;
			}
			maxValue=Math.max(maxValue, value);
		}
		//vertical
		for(int i=0;i<n;i++){
			value=0;
			for(Coin c:list){
				if(c.y==n)
					value+=c.value;
			}
			maxValue=Math.max(maxValue, value);
		}
		//diagonal
		
		//other
		return maxValue;
	}
}
