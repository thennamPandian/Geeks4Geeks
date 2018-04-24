package stack;

public class StackOptTest {

	public static void main(String[] args) {
		int[] data = new int[0]; 
		System.out.println("Array length : " + data.length);
		
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFulll());
		System.out.println(stack.size());
		System.out.println(stack.top());

		stack.push(11);
		System.out.println(stack.top());
		System.out.println(" popping :  " + stack.pop());
		System.out.println(" popping :  " + stack.pop());

		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}

		System.out.println(" $$$$$$$$$$ ");
		for (int i = 0; i < 10; i++) {
			System.out.println(" popping :  " + stack.pop());
		}
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFulll());
	}

}
