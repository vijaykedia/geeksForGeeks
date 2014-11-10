package trees;

public class ConstructTreeFromLevelOrder {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		KaryTreeNode root = constructTreeFromLevelOrder(arr, 3);
		printKaryTree(root, 3);
	}

	static KaryTreeNode constructTreeFromLevelOrder(int[] arr, int k) {
		KaryTreeNode temp = constructTreeFromLevelOrder(arr, k, 0);
		return temp;
	}

	static KaryTreeNode constructTreeFromLevelOrder(int[] arr, int k, int index) {
		KaryTreeNode temp = new KaryTreeNode(arr[index], k);
		for (int i = 0; i < k; i++) {
			if (index * k + i + 1 < arr.length) {
				temp.child[i] = constructTreeFromLevelOrder(arr, k, (index * k
						+ i + 1));
			} else {
				temp.child[i] = null;
			}
		}
		return temp;
	}

	static void printKaryTree(KaryTreeNode root, int k) {
		if (null == root) {
			return;
		}
		System.out.print(root.data + " ");
		for (int i = 0; i < k; i++) {
			printKaryTree(root.child[i], k);
		}
	}
}

class KaryTreeNode {
	int data;
	KaryTreeNode[] child;

	public KaryTreeNode(int data, int k) {
		this.data = data;
		child = new KaryTreeNode[k];
		for (int i = 0; i < k; i++) {
			child[i] = null;
		}
	}
}
