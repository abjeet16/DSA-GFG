/* Node Structure
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		data = val;
		left = right = null;
	}
} */
import java.util.ArrayList;
class Solution {
	public ArrayList<Integer> boundaryTraversal(Node root) {
		// code here
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		res.add(root.data);
		addLeft(root.left, res);
		addLeafs(root.left,res);
		addLeafs(root.right, res);
		addRight(root.right, res);
		
		return res;
	}
	
	private void addLeft(Node root, ArrayList<Integer> res) {
		if (root == null)
			return;
		
		if (root.left == null && root.right == null)
			return;
		
		res.add(root.data);
		
		if (root.left != null)
			addLeft(root.left, res);
		else
			addLeft(root.right, res);
	}
	
	private void addLeafs(Node root, ArrayList<Integer> res) {
		if (root == null)
			return;
		
		if (root.left == null && root.right == null) {
			res.add(root.data);
			return;
		}
		
		addLeafs(root.left, res);
		addLeafs(root.right, res);
	}
	
	private void addRight(Node root, ArrayList<Integer> res) {
		if (root == null)
			return;
		
		if (root.left == null && root.right == null)
			return;
		
		if (root.right != null)
			addRight(root.right, res);
		else
			addRight(root.left, res);
		
		res.add(root.data);
	}
}
