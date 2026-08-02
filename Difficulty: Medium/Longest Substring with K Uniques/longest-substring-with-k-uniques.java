class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int r = 0 , l = 0;
        int[] freq = new int[26];
        int res = -1;
        int curr = 0;
        while(r<n){
            int idx = s.charAt(r)-'a';
            if(freq[idx]==0)curr++;
            freq[idx]++;
            while(l<r&&curr>k){
                if(freq[s.charAt(l)-'a']==1){
                    curr--;
                }
                freq[s.charAt(l)-'a']--;
                l++;
            }
            if(curr==k)res=Math.max(res,r+1-l);
            r++;
        }
        return res;
    }
}