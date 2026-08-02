class Solution {
    boolean graphColoring(int v, int[][] e, int m) {
        // code here
        boolean[][] mat = new boolean[v][v];
        for(int[] r : e){
            mat[r[0]][r[1]]=true;
            mat[r[1]][r[0]] = true;
        }
        int[] c = new int[v];
        Arrays.fill(c,-1);
        if(solve(mat,c,m,0,v)==true)return true;
        return false;
    }
    private boolean solve(boolean[][] mat,int[] c , int m,int curr,int v){
        if(curr==v){
            return true;
        }
        for(int i = 0 ; i < m ; i++){
            if(isSafe(curr,mat,i,c)){
                c[curr]=i;
                if(solve(mat,c,m,curr+1,v))return true;
                c[curr]=-1;
            }
        }
        return false;
    }
    private boolean isSafe(int curr,boolean[][] e,int color,int[] c){
        for(int i = 0;i < e.length ; i++){
            if(e[curr][i]&&c[i]==color)return false;
            if(e[i][curr]&&c[i]==color)return false;
        }
        return true;
    }
}