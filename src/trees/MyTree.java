package trees;

class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;

	TreeNode(int data) {
		this.data = data;
		this.setLeft(null);
		this.setRight(null);
	}

	public int getdata() {
		return this.data;
	}

	public void setdata(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}