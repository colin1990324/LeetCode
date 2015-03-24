package Epic;

public class ContinousAlphabets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AbcDefljdflsjflmnopflsjflasjftuvWxYz";
		printContinousAlphabets(s);
	}

	public static void printContinousAlphabets(String in){
		if(in==null || in.length()<2)
			return;
		in = in.toLowerCase();
		int s=0;
		int e=1;
		while(e<in.length()){
			if(in.charAt(e-1)==in.charAt(e)-1)
				e++;
			else {
				if(e-s>1)
					System.out.print(in.substring(s,e)+";");
				s=e;
				e++;
			}
		}
		if(e-s>1)
			System.out.print(in.substring(s,e));
	}
}
