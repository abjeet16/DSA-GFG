class Solution {
    public int knapSack(int p[], int w[], int m) {
        // Write your code here.
        int[][] memo = new int[p.length][m+1];
        for(int[] i : memo)
            Arrays.fill(i,-1);
        return find(p,w,m,0,memo);
    }
    private static int find(int[] p ,int[] w ,int m , int i,int[][] memo){
        if(i==p.length||m==0)return 0;
        if(memo[i][m]!=-1)return memo[i][m];
        int skip = find(p,w,m,i+1,memo);
        int take = 0;
        if(m>=w[i]){
            take = p[i]+find(p,w,m-w[i],i,memo);
        }
        return memo[i][m]=Math.max(take,skip);
    }
}