package stack;

public class BalancedExperssion {

	public static void main(String[] args) {

		// null
		System.out.println("isBalanced : " + isBalanced(null));

		// empty
		System.out.println("isBalanced : " + isBalanced(""));

		// Tab space
		System.out.println("isBalanced : " + isBalanced("	"));

		// Balanced
		// Simple
		System.out.println("isBalanced : " + isBalanced("(a+b)"));

		// Complex 
		System.out.println("isBalanced : " + isBalanced("(A+B)+(C-D)"));

		// Complex with [, {
		System.out.println("isBalanced : " + isBalanced("[ {(A+B)}+{(C-D)}]"));
		
		//Not Balanced
		System.out.println("isBalanced : " + isBalanced("[ {(A+B)}+(C-D)}]"));

	}

	public static boolean isBalanced(String exp) {

		if (exp == null || exp.trim().length() == 0)
			return true;

		int i = 0;
		ObjectStack stack = new ObjectStack();
		while (i < exp.length()) {
			if (exp.charAt(i) == '}' || exp.charAt(i) == ']'
					|| exp.charAt(i) == ')') {
				Character ch = (Character) stack.pop();

				if (exp.charAt(i) == '}' && ch.charValue() != '{') {
					return false;
				} else if (exp.charAt(i) == ']' && ch.charValue() != '[') {
					return false;
				} else if (exp.charAt(i) == ')' && ch.charValue() != '(') {
					return false;
				}

			} else if (exp.charAt(i) == '{' || exp.charAt(i) == '['
					|| exp.charAt(i) == '(') {
				stack.push(exp.charAt(i));
			}

			i++;
		}

		return true;
	}
}
