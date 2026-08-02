class Solution {
    public int rowWithMax1s(int[][] arr) {
        // code here
        int ridx = -1;
        int ones = 0;
        int m = arr.length;
        for(int i = 0 ; i < m ; i ++){
            int curr = findOnes(arr[i]);
            if(curr>ones){
                ones = curr;
                ridx = i;
            }
        }
        return ridx;
    }
    private int findOnes(int[] arr){
        int left = 0 , right = arr.length-1;
        int res = arr.length;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==1){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return arr.length-res;
    }
};