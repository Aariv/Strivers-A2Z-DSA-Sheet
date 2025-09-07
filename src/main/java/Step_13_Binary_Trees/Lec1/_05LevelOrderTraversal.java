package Step_13_Binary_Trees.Lec1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Process one level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.data);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(level);
        }
        return result;
	}
}
