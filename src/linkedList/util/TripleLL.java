package linkedList.util;

public class TripleLL {

	private TripleLL next;
	private TripleLL prev;
	private Node child;

	public TripleLL getNext() {
		return next;
	}

	public void setNext(TripleLL next) {
		this.next = next;
	}

	public TripleLL getPrev() {
		return prev;
	}

	public void setPrev(TripleLL prev) {
		this.prev = prev;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

	public void print() {
		System.out.println("\n");
		TripleLL temp = this;
		if (temp != null) {
			// Going to the root.
			while (temp.getPrev() != null)
				temp = temp.getPrev();
			
			while (temp != null) {				
				Node node = temp.getChild();
				while (node != null) {
					System.out.print(node.getData() + "==>");
					node = node.getNext();
				}
				temp = temp.getNext();
				System.out.println();
			}
		}
	}
}
