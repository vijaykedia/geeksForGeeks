package geeksForGeeks.trees;

import java.util.Stack;

public class PreOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		System.out.print("PreOrder Traversal without recursion:\t");
		preOrderWithoutRecursion(root);
		System.out.print("\nPreOrder Traversal with recursion:\t");
		preOrderWithRecursion(root);
	}
	
	static void preOrderWithoutRecursion(TreeNode root) {
		if (null == root) {
			return;
		}
		TreeNode temp = root;
		Stack<TreeNode> lookup = new Stack<TreeNode>();
		while(true) {
			while(null != temp) {
				System.out.print(temp.getdata() + "\t");
				lookup.push(temp);
				temp = temp.getLeft();
			}
			if (lookup.isEmpty()) {
				break;
			} else {
				temp = lookup.pop();
				temp = temp.getRight();
			}
		}
		return;
	}
	
	static void preOrderWithRecursion(TreeNode root) {
		if (null == root) {
			return;
		}
		System.out.print(root.getdata() + "\t");
		preOrderWithRecursion(root.getLeft());
		preOrderWithRecursion(root.getRight());
	}
}