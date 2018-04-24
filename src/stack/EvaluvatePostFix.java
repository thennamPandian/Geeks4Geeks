package stack;

public class EvaluvatePostFix {

	public static void main(String[] args) {

		System.out.println(eveluvatePostFix(null));
		
		System.out.println(eveluvatePostFix("  "));
		
		System.out.println(eveluvatePostFix("3 2 +"));
		
		System.out.println(eveluvatePostFix("3 2 + 2 4 5 * - +"));
	}

	public static int eveluvatePostFix(String postFix) {
		int result = 0;
		
		if(postFix == null || postFix.trim().length() == 0) 
			return result;
		
		Stack stack = new Stack();
		for (int i = 0; i < postFix.length(); i++) {
			if(postFix.charAt(i) != ' ')
			if(postFix.charAt(i) != '+' && postFix.charAt(i) != '-' && postFix.charAt(i) != '*' && postFix.charAt(i) != '/') {
				int v = Integer.valueOf(Character.toString(postFix.charAt(i)));
				stack.push(v);
			} else {
				int b = stack.pop();
				int a = stack.pop();
				
				if(postFix.charAt(i) == '+') {
					result = a+b;					
				} else if (postFix.charAt(i) == '-'){
					result = a-b;
				} else if (postFix.charAt(i) == '*'){
					result = a*b;
				} else if (postFix.charAt(i) == '/'){
					result = a/b;
				}				
				stack.push(result);
			}
		}
		return result;
	}

}
