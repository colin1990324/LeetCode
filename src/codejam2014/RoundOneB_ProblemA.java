package codejam2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RoundOneB_ProblemA {

	int cases = 0;
	ArrayList<TheRepeater> list = new ArrayList<TheRepeater>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoundOneB_ProblemA roundOneB_ProblemA = new RoundOneB_ProblemA();
		roundOneB_ProblemA.read();
		for (int i = 0; i < roundOneB_ProblemA.cases; i++) {
			String out = "Case #" + (i + 1) + ": ";
			TheRepeater theRepeater = roundOneB_ProblemA.list.get(i);
			int result=theRepeater.sovler();
			if(result!=-1)
				out+=result;
			else
				out+="Fegla Won";
			System.out.println(out);
		}
	}

	public void read() {
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2014/RoundOneB_A.in";
		try {
			dFileReader = new FileReader(new File(urlString));
			br = new BufferedReader(dFileReader);
			String s = null;
			s = br.readLine();
			cases = Integer.valueOf(s);
			for (int i = 0; i < cases; i++) {
				s = br.readLine();
				int n = Integer.valueOf(s);
				TheRepeater theRepeater = new TheRepeater(n);
				for (int j = 0; j < n; j++) {
					s = br.readLine();
					theRepeater.list.add(s);
				}
				list.add(theRepeater);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TheRepeater {
	private int n;
	ArrayList<String> list=new ArrayList<String>();
	public TheRepeater(int n) {
		this.n = n;
	}
	public int sovler() {
		ArrayList<HashMap<String, Integer>> maps=new ArrayList<HashMap<String,Integer>>();
		for (int i = 0; i < n; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			subString(list.get(i), map);
			maps.add(map);
		}
		int maxLength=0;
		HashMap<String, Integer> longestMap = null;
		for (int i = 0; i < n; i++) {
			if(maps.get(i).size()>maxLength){
				maxLength=maps.get(i).size();
				longestMap=maps.get(i);
			}
		}
		ArrayList<String> common=new ArrayList<String>();
		Iterator<String> iterator=longestMap.keySet().iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			boolean flag=true;
			for (int i = 0; i < n; i++) {
				if(!maps.get(i).containsKey(string) && !longestMap.containsKey(list.get(i))){
					flag=false;
					break;
				}
			}
			if(flag)
				common.add(string);
		}
		if(common.size()==0)
			return -1;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < common.size(); i++) {
			int count=0;
			for (int j = 0; j < n; j++) {
				String aString=list.get(j);
				String bsString=common.get(i);
				int c=count(aString,bsString);
				if(c==-1){
					count=Integer.MAX_VALUE;
					break;
				}else
					count+=c;
			}
			if(count<min)
				min=count;
		}
		return min;
	}
	
	//subString
	private void subString(String s, HashMap<String, Integer> map) {
		char[] chars=s.toCharArray();
		if(!map.containsKey(s))
			map.put(s, 1);
		for (int i = 0; i < chars.length-1; i++) {
			if(chars[i]==chars[i+1]){
				if(i>1 && chars[i-1]==chars[i])
					continue;
				subString(s.substring(0, i)+s.substring(i+1), map);
			}
		}
	}
	
	
	//require a.length>b.length
	private int count(String a, String b) {
		if(a.length()<b.length()){
			String tmpString=a;
			a=b;
			b=tmpString;
		}
		int[] matrix=new int[a.length()+1];
		matrix[0]=0;
		int vecotr=0;
		char[] as=a.toCharArray();
		char[] bs=b.toCharArray();
		for (int i = 0; i < a.length(); i++) {
			if(vecotr!=b.length() && as[i]==bs[vecotr] ){
				matrix[i+1]=matrix[i];
				vecotr++;
				continue;
			}else if(i-1>=0){
				if(as[i]==as[i-1]){
					matrix[i+1]=matrix[i]+1;
					continue;
				}
			}
			return -1;
		}
		return matrix[matrix.length-1];
	}
}