/*
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		this.data = val;
		this.left = null;
		this.right = null;
	}
}
*/
class Pair {
	Node node;
	int i;
	Pair(Node n, int i) {
		this.node = n;
		this.i = i;
	}
}
class Solution {
	public ArrayList<Integer> topView(Node root) {
	    if (root == null)
            return new ArrayList<>();
		// code here
		ArrayList<Integer> res = new ArrayList<>();
		res.add(root.data);
		int L = 0;
		int R = 0;
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			Node node = p.node;
			int i = p.i;
			
			if (i<L) {
				L = i;
				res.addFirst(node.data);
			}
			if (i>R) {
				R = i;
				res.addLast(node.data);
			}
			if (node.left != null)
				q.offer(new Pair(node.left, i - 1));
			
			if (node.right != null)
				q.offer(new Pair(node.right, i + 1));
		}
		return res;
	}
}
