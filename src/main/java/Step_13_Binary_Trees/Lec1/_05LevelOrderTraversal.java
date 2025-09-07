package Step_13_Binary_Trees.Lec1;

import Step_13_Binary_Trees.Lec1._02Preorder_Traversal.TreeNode;

/**
 * Given the root of a Binary Tree, returns an array containing the level order
 * traversal of the tree.
 */
public class _05LevelOrderTraversal {

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		_05LevelOrderTraversal pt = new _05LevelOrderTraversal();
		pt.levelOrder(root);
	}
	
	public void levelOrder(TreeNode root) {
		// TODO: level order traversal
	}
}
