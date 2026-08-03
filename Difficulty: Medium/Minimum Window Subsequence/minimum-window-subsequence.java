class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        
        int resL = Integer.MAX_VALUE;
        int resS = -1;
        
        int i = 0;
        
        while(i < m){
            
            int j = 0;
            
            while(i < m){
                if(s1.charAt(i)==s2.charAt(j))j++;
                
                if(j==n)break;
                
                i++;
            }
            
            if(i==m)break;
            
            int end = i;
            j = n-1;
            
            while(j>=0){
                if(s1.charAt(i)==s2.charAt(j))j--;
                i--;
            }
            
            i++;
            if(end-i+1<resL){
                resS = i;
                resL = end-i+1;
            }
            i++;
        }
        
        if(resS==-1)return "";
        return s1.substring(resS,resS+resL);
    }
}
