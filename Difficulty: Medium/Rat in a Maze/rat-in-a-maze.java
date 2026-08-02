import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<String>();
        getpaths(res,new StringBuilder(),0,0,maze,maze.length);
        Collections.sort(res);
        return res;
    }
    private void getpaths(ArrayList<String> res ,StringBuilder curr,int i, int j,int[][] maze,int n){
        if(i==n-1&&j==n-1){
            res.add(curr.toString());
            return;
        }
        if(i<0||j<0||i==n||j==n||maze[i][j]==0)
            return;
        
        maze[i][j]=0;
        
        curr.append('U');
        getpaths(res,curr,i-1,j,maze,n);
        curr.deleteCharAt(curr.length()-1);
        
        curr.append('D');
        getpaths(res,curr,i+1,j,maze,n);
        curr.deleteCharAt(curr.length()-1);
        
        curr.append('L');
        getpaths(res,curr,i,j-1,maze,n);
        curr.deleteCharAt(curr.length()-1);
        
        curr.append('R');
        getpaths(res,curr,i,j+1,maze,n);
        curr.deleteCharAt(curr.length()-1);
        
        maze[i][j]=1;
    }
}