package microsoftCodingCompetition2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class DetectingUnreachableInstructions {

	private ArrayList<String> list = new ArrayList<String>();
	private HashSet<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DetectingUnreachableInstructions problem = new DetectingUnreachableInstructions();
		problem.solver(br);
	}
	private void solver(BufferedReader br){
		int i =0;
		while(true) {
			try {
				String s = br.readLine();
				if(s.length()==0)
					break;
				list.add(s);
				set.add(i);
				i++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		doNext(0);
		for(Integer index : set){
			System.out.println(index+1);
		}
	}
	
	private void doNext(int i){
		if(!set.contains(i))
			return;
		String s = list.get(i);
		if(s.equals("NEXT")){
			set.remove(i);
			if(i+1==list.size())
				return;
			doNext(i+1);
		}else{
			s = s.substring(5);
			int next = Integer.valueOf(s);
			set.remove(i);
			doNext(next-1);
		}
	}
}
