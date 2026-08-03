class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        int resi = -1 , resj = -1;
        for(int i = 0 ; i < s1.length() ; i ++){
            int j = i;
            int k = 0;
            while(j < s1.length()&&k<s2.length()){
                if(s1.charAt(j)==s2.charAt(k))k++;
                j++;
            }
            if(k==s2.length()){
                if(resi==-1||(resj-resi)>j-i){
                    resi = i;
                    resj = j;
                }
            }
        }
        if(resi==-1)return "";
        return s1.substring(resi,resj);
    }
}
