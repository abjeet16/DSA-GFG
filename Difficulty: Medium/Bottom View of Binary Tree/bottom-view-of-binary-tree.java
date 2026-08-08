/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
class Pair{
    Node n;
    int i;
    Pair(Node n,int i){
        this.n=n;
        this.i=i;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node n = p.n;
            int i = p.i;
            map.put(i,n.data);
            
            if(n.left!=null)q.offer(new Pair(n.left,i-1));
            if(n.right!=null)q.offer(new Pair(n.right,i+1));
        }
        return new ArrayList<>(map.values());
    }
}