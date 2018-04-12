package linkedList.util;

public class ListUtil {

	public static Node createList(String[] values) {
		Node head = null, cur = null, temp = null;
		for (String value : values) {
			if (!value.trim().equals("")) {
				temp = new Node();
				temp.setData(Integer.valueOf(value));
				temp.setNext(null);

				if (head == null) {
					head = temp;
				} else {
					cur.setNext(temp);
				}

				cur = temp;
			}
		}
		return head;
	}

	public static Node createList(int[] values) {
		Node head = null, cur = null, temp = null;
		for (int value : values) {
			temp = new Node();
			temp.setData(value);
			temp.setNext(null);

			if (head == null) {
				head = temp;
			} else {
				cur.setNext(temp);
			}

			cur = temp;

		}
		return head;
	}

	public static void displayList(Node head) {
		Node temp = head;

		System.out.println();
		if (temp == null) {
			System.out.println("Empty List");
			return;
		}

		while (temp != null) {
			System.out.print(temp.getData() + ",");
			temp = temp.getNext();
		}
	}

	public static void displayList(RandomPointerNode head) {
		RandomPointerNode temp = head;

		System.out.println();
		if (temp == null) {
			System.out.println("Empty List");
			return;
		}

		while (temp != null) {
			int data = temp.getNext() != null ? temp.getNext().getData() : -1;
			System.out.print("[" + temp.getData() + " : " + data + "] ,");
			temp = temp.getNext();
		}
	}

	public static Node findNode(Node head, int data) {
		Node node = head;
		while (node != null) {
			if (node.getData() == data) {
				break;
			}

			node = node.getNext();
		}
		return node;
	}

	public static Node reverse(Node head) {

		if (head == null)
			return head;
		Node newHead = null;
		Node cur = head;
		Node temp = null;

		while (cur != null) {
			temp = cur;
			cur = cur.getNext();
			temp.setNext(newHead);
			newHead = temp;
		}

		return newHead;
	}

	public static void displayList(DoublyLL head) {

		DoublyLL temp = head;

		while (temp != null) {
			System.out.print(temp.getData()+"==>");
			temp = temp.getNext();
		}
	}
}
