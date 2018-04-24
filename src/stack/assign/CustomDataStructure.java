package stack.assign;

import stack.Stack;

//Design a DS which have push () pop() and getmin() in O(1) 
public class CustomDataStructure {

	private Stack elements;
	private Stack min;
	
	public CustomDataStructure() {
		this(5);
	}

	public CustomDataStructure(int capacity) {
		this.elements = new Stack(capacity);
		this.min = new Stack(capacity);
		
	}

	public boolean isEmpty() {
		return this.elements.isEmpty();
	}

	public int top() {
		return this.elements.top();
	}

	public int size() {
		return this.elements.size();
	}

	public boolean isFulll() {
		return this.elements.isFulll();
	}

	public void push(int data) {
		this.elements.push(data);
		int minData = this.min.top();
		if(minData == -1) {
			this.min.push(data);
		} else if(minData > data ){
			this.min.push(data);
		}else {
			this.min.push(minData);
		}
		
	}

	public int pop() {
		this.min.pop();
		return this.elements.pop();
	}
	
	
	public int getMin(){
		return this.min.top();
	}

}
