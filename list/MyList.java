package geeksForGeeks.list;
public class MyList {
	ListNode head;
	int size;
	ListNode tail;
		
	void push (int data) {
		if (null == head) {
			head = new ListNode (data); 
		} else {
			ListNode temp = new ListNode (data);
			size++;
			temp.next = head;
			head = temp;
		}
	}
	
	void swapPairWise() { 
		//http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
		if (null == head || null == head.next) {
			return;
		}
		ListNode prev = head;
		ListNode curr = prev.next;;
		head = curr;
		while (true) {
			ListNode temp = curr.next;
			curr.next = prev;
			if (null == temp || null == temp.next) {
				prev.next = temp;
				break;
			}
			prev.next = temp.next;
			prev = temp;
			curr = prev.next;
		}
	}
	
	void swapPairWiseRecursive() { 
		//http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
		if (null == head || null == head.next) {
			return;
		}
		ListNode curr = head.next;
		ListNode rest = curr.next;
		curr.next = head;
		head = curr;
		head.next.next = swapPairWiseRecursive(rest);
	}
	
	private ListNode swapPairWiseRecursive (ListNode rest) {
		if (null == rest || null == rest.next) {
			return rest;
		}
		ListNode curr = rest.next;
		ListNode remain = curr.next;
		ListNode  temp = rest;
		curr.next = temp;
		temp.next = swapPairWiseRecursive(remain);
		return curr;
	}
	
	void reverse() {
		if (null == head) {
			return;
		}
		ListNode curr = head;
		while (curr != null) {
			
		}
	}
	
	void insertAfter(int data, ListNode after) {
		if (null == head) {
			return;
		}
		if (null == after) {
			System.err.println("AfterNode can't be empty");
			return;
		}
		ListNode temp = new ListNode(data);
		size++;
		temp.next = after.next;
		after.next = temp;
		return;
 	}
	
	void append(int data) {
		ListNode temp = new ListNode(data);
		size++;
		tail.next = temp;
		tail = temp;
	}
	
	void delete (int data) {
		if (null == head) {
			return;
		}
		if (head.data == data) {
			head = head.next;
			size--;
			return;
		}
		ListNode prev = head;
		ListNode curr = head.next;
		while (curr != null) {
			if (curr.data == data) {
				prev.next = curr.next;
				size--;
				return;
			} else {
				prev = prev.next;
				curr = prev.next;
			}
		}
	}
	
	Boolean isEmpty() {
		if (null == head) {
			return true;
		} else {
			return false;
		}		
	}
	
	Boolean exists(int data) {
		if (null == head) {
			return false;
		} else {
			ListNode curr = head;
			while (curr != null) {
				if (curr.data == data) {
					return true;
				}
				curr = curr.next;
			}
			return false;
		}
	}
	
	void print() {
		if (null == head) {
			return;
		} else {
			ListNode curr = head;
			while (curr.next != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
			System.out.println(curr.data);
		}
	}
}

class ListNode {
	int data;
	ListNode next;
	
	ListNode(int data) {
		this.data = data;
		next = null;
	}
}