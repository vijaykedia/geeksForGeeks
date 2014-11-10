package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		System.out.print("LevelOrder Traversal without recursion:\t");
		levelOrder(root);
	}

	static void levelOrder(TreeNode root) {
		if (null == root) {
			return;
		}
		TreeNode temp = root;
		Queue<TreeNode> lookup = new LinkedList<TreeNode>();
		while (true) {
			System.out.print(temp.getdata() + "\t");
			if (null != temp.getLeft()) {
				lookup.add(temp.getLeft());
			}
			if (null != temp.getRight()) {
				lookup.add(temp.getRight());
			}
			if (lookup.isEmpty()) {
				break;
			}
			temp = lookup.remove();
		}
		return;
	}
}
