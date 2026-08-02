// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        // code here
        int ri = -1;
        int rj = -1;
        int rs = 0;
        int cs = 0;
        int i = -1;
        int j = 0;
        int n = arr.length;
        for(int e : arr){
            cs+=e;
            if(e < 0){
                i=-1;
                cs = 0;
            }else if(i==-1){
                i = j;
            }
            if(i!=-1&&(rs<cs||(rs==cs&&rj-ri<j-i))){
                rs=cs;
                rj=j;
                ri=i;
            }
            j++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (ri == -1) {
            res.add(-1);
            return res;
        }
        while(ri<=rj){
            res.add(arr[ri]);
            ri++;
        }
        return res;
    }
}