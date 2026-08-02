class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean[][] mat = new boolean[V][V];
        makeMat(mat,edges);
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++)
            if(!vis[i])dfs(vis,mat,i,res,V);
        return res; 
    }
    private void makeMat(boolean[][] mat,int[][] edges){
        for(int[] conn : edges){
            mat[conn[1]][conn[0]] = true;
        }
    }
    private void dfs(boolean[] vis,boolean[][] mat,int v,ArrayList<Integer> res,int V){
        if(vis[v])return;
        vis[v]=true;
        for(int i = 0;i < V ;i++){
            if(mat[v][i])dfs(vis,mat,i,res,V);
        }
        res.add(v);
    }
}