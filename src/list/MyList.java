package list;

//List implementation using linkedList 
public class MyList {
	private ListNode head;
	private int size;
	private ListNode tail;

	MyList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public ListNode getHead() {
		return this.head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public ListNode getTail() {
		return this.tail;
	}

	public void setTail(ListNode tail) {
		this.tail = tail;
	}

	// Below three functions add(int data); add(int index, int data) and
	// push(int data) are for insertion.
	// Reference : http://geeksquiz.com/linked-list-set-2-inserting-a-node/

	void add(int data) {
		// insert the data at the end of the list
		if (null == tail) {
			tail = new ListNode(data);
			head = tail;
		} else {
			ListNode temp = new ListNode(data);
			tail.setNext(temp);
			tail = temp;
		}
		size++;
	}

	void push(int data) {
		// insert the data at the start of the list
		if (null == head) {
			head = new ListNode(data);
			tail = head;
		} else {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		}
		size++;
	}

	void add(int index, int data) {
		// insert the data at any specified index
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Invalid Index");
		} else if (index == 0) {
			push(data);
		} else if (index == size()) {
			add(data);
		} else {
			int count = 1;
			ListNode prev = head;
			ListNode curr = prev.getNext();
			while (count != index) {
				prev = curr;
				curr = curr.getNext();
				count++;
			}
			ListNode temp = new ListNode(data);
			temp.setNext(curr);
			prev.setNext(temp);
			size++;
		}
	}

	int size() {
		// returns size of list
		return size;
	}

	void delete(int data) {
		// it deletes the particular element from list if found else fails
		// silently
		if (null == head) {
			return;
		}
		if (data == head.getData()) {
			head = head.getNext();
			size--;
			return;
		}
		ListNode prev = head;
		ListNode curr = head.getNext();
		while (curr != null) {
			if (data == curr.getData()) {
				prev.setNext(curr.getNext());
				size--;
				return;
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}
	}

	Boolean isEmpty() {
		// it tells whether list is empty or not
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	Boolean exists(int data) {
		// it tells whether particular elements exists or not
		if (null == head) {
			return false;
		} else {
			ListNode curr = head;
			while (curr != null) {
				if (curr.getData() == data) {
					return true;
				}
				curr = curr.getNext();
			}
			return false;
		}
	}

	void print() {
		// prints the list
		if (null == head) {
			return;
		} else {
			ListNode curr = head;
			while (curr.getNext() != null) {
				System.out.print(curr.getData() + " ");
				curr = curr.getNext();
			}
			System.out.println(curr.getData());
		}
	}

}

class ListNode {
	private int data;
	private ListNode next;

	ListNode(int data) {
		this.data = data;
		next = null;
	}

	public int getData() {
		return this.data;
	}

	public ListNode getNext() {
		return this.next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}