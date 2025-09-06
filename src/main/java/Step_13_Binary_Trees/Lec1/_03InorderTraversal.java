package Step_13_Binary_Trees.Lec1;

import Step_13_Binary_Trees.Lec1._02Preorder_Traversal.TreeNode;

/**
 * Given root of binary tree, return the Inorder traversal of the binary tree.
 */
public class _03InorderTraversal {

	public void inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		// Visit Left
		inorder(root.left);
		// Visit Root
		System.out.print(root.data + " ");
		// Visit Right
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		_03InorderTraversal pt = new _03InorderTraversal();
		pt.inorder(root);
	}
}
