package trees;

import java.util.Stack;

public class InOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		System.out.print("InOrder Traversal without recursion:\t");
		inOrderWithoutRecursion(root);
		System.out.print("\nInOrder Traversal with recursion:\t");
		inOrderWithRecursion(root);
	}

	static void inOrderWithoutRecursion(TreeNode root) {
		if (null == root) {
			return;
		}
		TreeNode temp = root;
		Stack<TreeNode> lookup = new Stack<TreeNode>();
		while (true) {
			while (null != temp) {
				lookup.push(temp);
				temp = temp.getLeft();
			}
			if (lookup.isEmpty()) {
				break;
			} else {
				temp = lookup.pop();
				System.out.print(temp.getdata() + "\t");
				temp = temp.getRight();
			}
		}
		return;
	}

	static void inOrderWithRecursion(TreeNode root) {
		if (null == root) {
			return;
		}
		inOrderWithRecursion(root.getLeft());
		System.out.print(root.getdata() + "\t");
		inOrderWithRecursion(root.getRight());
	}
}
