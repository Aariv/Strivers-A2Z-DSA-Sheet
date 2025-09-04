package Step_13_Binary_Trees.Lec1;

public class _02Preorder_Traversal {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
		}
		
	}

	public void preorder(TreeNode root) {
		if(root == null) {
			return;
		}
		// Visit Root
		System.out.print(root.data + " ");
		// Visit Left
		preorder(root.left);
		// Visit Right
		preorder(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		_02Preorder_Traversal pt = new _02Preorder_Traversal();
		pt.preorder(root);
	}
}
