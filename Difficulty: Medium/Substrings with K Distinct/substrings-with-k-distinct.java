class Solution {
    public int countSubstr(String s, int k) {
        //  code here
        int j = 0;
        int[] freq = new int[26];
        int common = 0;
        int dist = 0;
        int res = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            int chi = s.charAt(i)-'a';
            if(freq[chi]==0)dist++;
            freq[chi]++;
            
            if(dist>k){
                while(dist>k){
                    int chj = s.charAt(j)-'a';
                    if(freq[chj]==1)dist--;
                    freq[chj]--;
                    j++;
                }
                common = 0;
            }
            
            while(j<i&&freq[s.charAt(j)-'a']>1){
                freq[s.charAt(j)-'a']--;
                common++;
                j++;
            }
            
            if(dist==k)res+=common+1;
        }
        return res;
    }
}