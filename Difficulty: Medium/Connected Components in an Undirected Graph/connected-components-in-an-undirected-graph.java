import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        int[] par = new int[V];
        for (int i = 0; i < V; i++) {
            par[i] = i;
        }
        
        int[] rank = new int[V];
        
        // Union operations
        for (int[] edge : edges) {
            int pu = find(par, edge[0]);
            int pv = find(par, edge[1]);
            
            if (pu != pv) {
                uni(pu, pv, par, rank);
            }
        }
        
        // Group vertices by their ultimate root representative
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < V; i++) {
            int root = find(par, i); // MUST use find() to resolve full path compression
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(i);
        }
        
        // Collect all components into the final list
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(map.values());
        return res;
    }
    
    private int find(int[] par, int i) {
        if (i == par[i]) return i;
        return par[i] = find(par, par[i]);
    }
    
    private void uni(int pu, int pv, int[] par, int[] rank) {
        if (rank[pu] == rank[pv]) {
            par[pu] = pv;
            rank[pv]++;
        } else if (rank[pu] > rank[pv]) {
            par[pv] = pu;
        } else {
            par[pu] = pv;
        }
    }
}