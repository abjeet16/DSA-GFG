class Solution {
    public int cutRod(int[] p) {
        int n = p.length;
        // Write your code here.
		int[][] memo = new int[n][n+1];
		for(int[] i : memo)Arrays.fill(i,-1);
		return find(p,n-1,n,memo);
	}
	private static int find(int[] p,int i,int rem,int[][] memo){
		if(i<0||rem==0)return 0;
		if(memo[i][rem]!=-1)return memo[i][rem];
		int skip = find(p,i-1,rem,memo);
		int cut = 0;
		if(i+1<=rem){
			cut = p[i]+find(p,i,rem-i-1,memo);
		}
		return memo[i][rem]=Math.max(skip,cut);
	}
}