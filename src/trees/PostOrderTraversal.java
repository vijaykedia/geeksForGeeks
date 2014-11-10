package trees;

import java.util.Stack;

public class PostOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		root.getLeft().getLeft().setLeft(new TreeNode(8));
		root.getLeft().getLeft().setRight(new TreeNode(9));
		root.getLeft().getRight().setLeft(new TreeNode(10));
		root.getLeft().getRight().setRight(new TreeNode(11));
		root.getRight().getLeft().setLeft(new TreeNode(12));
		root.getRight().getLeft().setRight(new TreeNode(13));
		root.getRight().getRight().setLeft(new TreeNode(14));
		root.getRight().getRight().setRight(new TreeNode(15));

		System.out.print("PostOrder Traversal with recursion:\t");
		postOrderWithRecursion(root);
		System.out.print("\nPostOrder Traversal without recursion:\t");
		postOrderWithoutRecursion(root);
	}

	static void postOrderWithoutRecursion(TreeNode root) {
		if (null == root) {
			return;
		}
		TreeNode temp = root;
		Stack<TreeNode> lookup = new Stack<TreeNode>();
		Stack<Boolean> state = new Stack<Boolean>();
		while (true) {
			while (null != temp) {
				lookup.push(temp);
				state.push(false);
				temp = temp.getLeft();
			}
			if (lookup.isEmpty()) {
				break;
			}
			if (state.peek() == false) {
				state.pop();
				state.push(true);
				temp = lookup.peek().getRight();
				continue;
			} else {
				state.pop();
				temp = lookup.pop();
				System.out.print(temp.getdata() + "\t");
				temp = null;
			}
		}
		return;
	}

	static void postOrderWithRecursion(TreeNode root) {
		if (null == root) {
			return;
		}
		postOrderWithRecursion(root.getLeft());
		postOrderWithRecursion(root.getRight());
		System.out.print(root.getdata() + "\t");
	}
}
