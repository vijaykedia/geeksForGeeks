//http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
package list;

public class PairWiseSwap {
	public static void main(String[] args) {
		MyList list = new MyList();
		list.add(1);
		list.add(2);
		list.add(0, 8);
		list.add(3);
		list.add(4, 5);
		list.print();
		swapPairWise(list);
		list.print();
		swapPairWiseRecursive(list);
		list.print();
	}

	static void swapPairWise(MyList list) {
		if (null == list) {
			return;
		}

		if (list.size() == 0 || list.size() == 1) {
			return;
		}

		ListNode prev = list.getHead();
		ListNode curr = prev.getNext();
		;
		list.setHead(curr);
		ListNode temp = null;
		while (true) {
			temp = curr.getNext();
			curr.setNext(prev);
			if (null == temp || null == temp.getNext()) {
				prev.setNext(temp);
				if (null == prev.getNext()) {
					list.setTail(prev);
				} else {
					list.setTail(temp);
				}
				break;
			}
			prev.setNext(temp.getNext());
			prev = temp;
			curr = prev.getNext();
		}
	}

	static void swapPairWiseRecursive(MyList list) {
		if (list.size() == 0 || list.size() == 1) {
			return;
		}
		ListNode temp = list.getHead();
		ListNode curr = temp.getNext();
		ListNode rest = curr.getNext();
		curr.setNext(temp);
		list.setHead(curr);
		temp.setNext(swapPairWiseRecursive(list, rest));
	}

	private static ListNode swapPairWiseRecursive(MyList list, ListNode rest) {
		if (null == rest || null == rest.getNext()) {
			if (rest != null) {
				list.setTail(rest);
			}
			return rest;
		}
		ListNode curr = rest.getNext();
		ListNode remain = curr.getNext();
		curr.setNext(rest);
		if (null == remain) {
			list.setTail(rest);
		}
		rest.setNext(swapPairWiseRecursive(list, remain));
		return curr;
	}
}
