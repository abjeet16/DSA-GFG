class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[][] mat = new boolean[V][V];
        formMat(mat,edges);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int d = curr[1];
            //System.out.println(node+" "+d);
            if(node==dest)return d;
            
            for(int i = 0 ; i < V ; i++){
                if(mat[node][i]&&dist[i]>d+1){
                    //System.out.println(i);
                    dist[i] = d+1;
                    q.offer(new int[]{i,d+1});
                }
            }
        }
        return -1;
    }
    private void formMat(boolean[][] mat , int[][] edges){
        for(int[] edge : edges){
            int s = edge[0];
            int d = edge[1];
            mat[s][d] = true;
            mat[d][s] = true;
        }
    }
    private void display(boolean[][] mat){
        for(boolean[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
/*
import java.util.Arrays;
class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        List<List<Integer>> mat = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++)mat.add(new ArrayList<>());
        for(int e[] : edges){
            mat.get(e[0]).add(e[1]);
            mat.get(e[1]).add(e[0]);
        }
        
        int[] res = new int[V];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int i : mat.get(curr)){
                if(res[i]>res[curr]+1){
                    res[i] = res[curr]+1;
                    q.offer(i);
                }
            }
        }
        
        //fill unreachable 
        for(int i = 0; i<V ;i++)
            if(res[i]==Integer.MAX_VALUE)res[i]=-1;
        return res;
    }
}
*/