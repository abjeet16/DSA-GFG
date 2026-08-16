class Solution {
    public int setBits(int n) {
        // code here
        int res = 0;
        while(n!=0){
            res+=n%2;
            n/=2;
        }
        return res;
    }
}