/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        find(root,new ArrayList<Integer>(),res);
        
        return res;
    }
    
    private void find(Node root,ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> res){
        if(root.left==null&&root.right==null){
            curr.add(root.data);
            res.add(new ArrayList<>(curr));
            curr.removeLast();
            return;
        }
        curr.add(root.data);
        if(root.left!=null)
            find(root.left,curr,res);
        if(root.right!=null)
            find(root.right,curr,res);
        curr.removeLast();
    }
}