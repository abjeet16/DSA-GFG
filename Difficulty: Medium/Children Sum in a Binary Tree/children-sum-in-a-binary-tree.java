/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null||(root.left==null&&root.right==null))return true;
        
        int left = root.left==null?0:root.left.data;
        int right = root.right==null?0:root.right.data;
        
        if(root.data!=left+right)return false;
        
        return isSumProperty(root.left)&&isSumProperty(root.right);
    }
}