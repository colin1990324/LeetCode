import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="leetcode";
		Set<String> dict=new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("a");
		//System.out.println(wordBreak("aab", dict));
		Set<String> dict2=new HashSet<String>();
		dict2.add("cat");
		dict2.add("cats");
		dict2.add("and");
		dict2.add("sand");
		dict2.add("dog");
		String string2="catsanddog";
		ArrayList<String> resultArrayList=wordBreakDPT(string2,dict2);
		Iterator<String> iterator=resultArrayList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	public static boolean wordBreak(String s, Set<String> dict) {
		if(dict.contains(s))
			return true;
		for(int i=s.length()-1;i>-1;i--){
			if(dict.contains(s.substring(0, i))){
				if(wordBreak(s.substring(i), dict))
					return true;
				else
					continue;
			}
		}
        return false;
    }
	public boolean wordBreakDP(String s, Set<String> dict) {
	    int length = s.length();
	    boolean[] can = new boolean[length+1];
	    can[0] = true;
	    for (int i = 1; i <= length; i++) {
	        for (int j = 0; j < i; j++) {
	            if (can[j] && dict.contains(s.substring(j, i))) {
	                can[i] = true;
	                break;
	            }
	        }
	    }
	    return can[length];
	}
	public static ArrayList<String> wordBreakDPT(String s, Set<String> dict) {
	    int length = s.length();
	    ArrayList<ArrayList<Integer>> track= new ArrayList<ArrayList<Integer>>();
	    for(int i=0;i<=length;i++)
	    	track.add(new ArrayList<Integer>());
	    boolean[] can = new boolean[length+1];
	    can[0] = true;
	    for (int i = 1; i <= length; i++) {
	        for (int j = 0; j < i; j++) {
	            if (can[j] && dict.contains(s.substring(j, i))) {
	                can[i] = true;
	                //keep trace
					track.get(i).add(j);
	            }
	        }
	    }
	    //trace back
	    if(can[length]){
	    	ArrayList<String> result=new ArrayList<String>();
	    	traceHelper(s, track, result, length, "");
	    	return result;
	    }else{
	    	return new ArrayList<String>();
	    }
	}
	public static void traceHelper(String s, ArrayList<ArrayList<Integer>> track, ArrayList<String> result, int pointer, String string) {
		Iterator<Integer> iterator=track.get(pointer).iterator();
		while(iterator.hasNext()){
			int i=iterator.next();
			if(i==0){
				String tmpString=s.substring(0, pointer)+" "+string;
				result.add(tmpString.substring(0, tmpString.length()-1));
			}
			else{
				traceHelper(s, track, result, i, s.subSequence(i, pointer)+" "+string);
			}
		}
	}
}
