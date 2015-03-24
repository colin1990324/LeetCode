package interview;

public class IN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt="TripAdvisor candidate";
		String pat="**da";
		String pat2="vi*da";
		System.out.println(isSubstring(pat2.toCharArray(),txt.toCharArray()));
	}

	static boolean isSubstring(char[] pat, char[] txt){
	    int index =0;
	    while(pat[index]=='*'){
	        index++;
	    }
	    if(pat.length==index)
	        return true;
	    boolean flag = false;
	    for(int i = 0; i<txt.length;i++){
	        if(txt[i]==pat[index]){
	            if(helper(pat,index,txt,i)){
	                flag=true;    
	                break;
	            }
	        }
	    }
	    return flag;
	}

	static boolean helper(char[] pat, int indexP, char[] txt, int indexT){
	    if(indexP<pat.length && indexT >= txt.length && pat[indexP]!='*')
	        return false;
	    if(indexP==pat.length)
	        return true;
	    if(txt[indexT]==pat[indexP]){
	        return helper(pat,indexP+1,txt,indexT+1);
	    }
	    if(pat[indexP]=='*'){
	        return helper(pat,indexP,txt,indexT+1) || helper(pat,indexP+1,txt,indexT);
	    }
	    return false;
	}
}
