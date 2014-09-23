package interview;

public class NumberGame {

	public static void main(String[] args) {
		System.out.println(solver("3","3","3"));
		System.out.println(solver("3","3","4"));
		System.out.println(solver("10","11","13"));
		System.out.println(solver("1","17","43"));
	}

	enum MODE {
		FIRST, SECOND;
		public MODE next() {
			if (this == FIRST)
				return SECOND;
			else
				return FIRST;
		}
	}

	public static MODE solver(String a, String b, String c) {
		if (a.equals(b) && b.equals(c)) {
			return MODE.SECOND;
		} else {
			if (solver(average(b, c), b, c, 1, MODE.SECOND)
					|| solver(a, average(a, c), c, 2, MODE.SECOND)
					|| solver(a, b, average(a, b), 3, MODE.SECOND))
				return MODE.FIRST;
			else
				return MODE.SECOND;
		}
	}

	private static boolean solver(String a, String b, String c, int pre, MODE mode) {
		String aa=a;
		String bb=b;
		String cc=c;
		if(pre==1){
			String aver = average(b,c);
			if(aver.equals(a)){
				if(mode==MODE.SECOND)
					return true;
				else
					return false;
			}
			aa=aver;
		}
		if(pre==2){
			String aver = average(a,c);
			if(aver.equals(b)){
				if(mode==MODE.SECOND)
					return true;
				else
					return false;
			}
			bb=aver;
		}
		if(pre==3){
			String aver = average(b,a);
			if(aver.equals(c)){
				if(mode==MODE.SECOND)
					return true;
				else
					return false;
			}
			cc=aver;
		}
		if (aa.equals(bb) && bb.equals(cc)) {
			if (mode == MODE.FIRST)
				return false;
			else
				return true;
		} else if (aa.equals(bb) || aa.equals(cc) || cc.equals(bb)) {
			solver(aa, aa, aa, 0, mode.next());
		} else if (mode == MODE.FIRST) {
			if (pre == 1) {
				if (solver(aa, bb, cc, 2, mode.next())
						|| solver(aa, bb, cc, 3, mode.next()))
					return true;
			} else if (pre == 2) {
				if (solver(aa, bb, cc, 1, mode.next())
						|| solver(aa, bb, cc, 3, mode.next()))
					return true;
			} else if (pre == 3) {
				return solver(aa, bb, cc, 2, mode.next())
						|| solver(aa, bb, cc, 1, mode.next());
			}
		} else if (mode == MODE.SECOND) {
			if (pre == 1) {
				if (!solver(aa, bb, cc, 2, mode.next())
						|| !solver(aa, bb, cc, 3, mode.next()))
					return false;
			} else if (pre == 2) {
				if (!solver(average(bb, cc), bb, cc, 1, mode.next())
						|| !solver(aa, bb, cc, 3, mode.next()))
					return false;
			} else if (pre == 3) {
				if (!solver(aa, bb, cc, 2, mode.next())
						|| !solver(aa, bb, cc, 1, mode.next()))
					return false;
			}
			return true;
		}
		return false;
	}

	private static String average(String num1, String num2) {
		String sum = plus(num1, num2);
		String result = "";
		int carry = 0;
		for (int i = 0; i < sum.length(); i++) {
			int a = Integer.valueOf(sum.charAt(i)) - 48;
			result = result + (a + 10 * carry) / 2;
			carry = (a + 10 * carry) % 2;
		}
		if (result.charAt(0) == '0')
			result = result.substring(1);
		return result;
	}

	private static String plus(String num1, String num2) {
		String result = "";
		int carry = 0;
		String aString;
		String bString;
		if (num1.length() > num2.length()) {
			aString = num1;
			bString = num2;
		} else {
			aString = num2;
			bString = num1;
		}
		int i = aString.length() - 1;
		int diff = aString.length() - bString.length();
		while (i >= 0) {
			int a = Integer.valueOf(aString.charAt(i)) - 48;
			int b = i - diff >= 0 ? Integer.valueOf(bString.charAt(i - diff)) - 48
					: 0;
			result = (a + b + carry) % 10 + result;
			carry = (a + b + carry) / 10;
			i--;
		}
		if (carry > 0)
			result = carry + result;
		return result;
	}

}
