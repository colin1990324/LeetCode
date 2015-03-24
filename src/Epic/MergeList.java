package Epic;

import java.util.ArrayList;
import java.util.List;

public class MergeList {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("abc");
		a.add("acc");
		a.add("adc");
		ArrayList<String> b = new ArrayList<String>();
		b.add("abc");
		b.add("bbc");
		b.add("bcc");
		System.out.println(merge(a,b));
	}

	//merge String list delete duplicates
	//assume no duplicates within each input
	public static List<String> merge(List<String> a, List<String> b){
		for(String sa : a){
			boolean flag = true;
			for(String sb:b){
				if(sa.equals(sb)){
					flag = false;
					break;
				}
			}
			if(flag)
				b.add(sa);
		}
		return b;
	}
}
