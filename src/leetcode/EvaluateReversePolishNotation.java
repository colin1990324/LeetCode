package leetcode;
/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] exampleOneStrings = { "2", "1", "+", "3", "*" };
		String[] exampleTwoStrings = { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN(exampleOneStrings));
		System.out.println(evalRPN(exampleTwoStrings));
	}
	public static int evalRPN(String[] tokens) {
        return evalRPN(tokens, 0, tokens.length - 1);
    }
	public static int evalRPN(String[] tokens, int head, int tail) {
		int a = 0;
		int OperatorCount = 0;
		int numberCount = 0;
		if (tail - head == 0) {
			return Integer.valueOf(tokens[head]);
		}else if (tail - head == 2) {
			if (tokens[tail].equals("+")) {
				a = Integer.valueOf(tokens[tail - 2])
						+ Integer.valueOf(tokens[tail - 1]);
			} else if (tokens[tail].equals("-")) {
				a = Integer.valueOf(tokens[tail - 2])
						- Integer.valueOf(tokens[tail - 1]);
			} else if (tokens[tail].equals("*")) {
				a = Integer.valueOf(tokens[tail - 2])
						* Integer.valueOf(tokens[tail - 1]);
			} else if (tokens[tail].equals("/")) {
				a = Integer.valueOf(tokens[tail - 2])
						/ Integer.valueOf(tokens[tail - 1]);
			}
		} else if (!isOperator(tokens[tail - 1])) {
			if (tokens[tail].equals("+")) {
				a = evalRPN(tokens, head, tail - 2)
						+ Integer.valueOf(tokens[tail - 1]);
			} else if (tokens[tail].equals("-")) {
				a = evalRPN(tokens, head, tail - 2)
						- Integer.valueOf(tokens[tail - 1]);
			} else if (tokens[tail].equals("*")) {
				a = evalRPN(tokens, head, tail - 2)
						* Integer.valueOf(tokens[tail - 1]);
			} else if (tokens[tail].equals("/")) {
				a = evalRPN(tokens, head, tail - 2)
						/ Integer.valueOf(tokens[tail - 1]);
			}
		} else {
			int i = tail;
			while (numberCount <= OperatorCount && i >= head) {
				if (isOperator(tokens[i - 1])) {
					OperatorCount++;
				} else {
					numberCount++;
				}
				i--;
			}
			if (tokens[tail].equals("+")) {
				a = evalRPN(tokens, head, i - 1) + evalRPN(tokens, i, tail - 1);
			} else if (tokens[tail].equals("-")) {
				a = evalRPN(tokens, head, i - 1) - evalRPN(tokens, i, tail - 1);
			} else if (tokens[tail].equals("*")) {
				a = evalRPN(tokens, head, i - 1) * evalRPN(tokens, i, tail - 1);
			} else if (tokens[tail].equals("/")) {
				a = evalRPN(tokens, head, i - 1) / evalRPN(tokens, i, tail - 1);
			}
		}
		return a;
	}

	public static boolean isOperator(String string) {
		if (string.equals("+") || string.equals("-") || string.equals("*")
				|| string.equals("/")) {
			return true;
		} else {
			return false;
		}
	}
}
