class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k)return -1;
        long left = Integer.MIN_VALUE;
        long right = 0;
        for(int i : arr){
            left = Math.max(i,left);
            right+=i;
        }
        long res = 0;
        while(left <= right){
            long mid = (left+right)/2;
            if(check(arr,mid,k)){
                res = mid;
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return (int)res;
    }
    
    private boolean check(int[] arr,long mid , int k){
        int s = 1;
        int p = 0;
        
        for(int i : arr){
            if(p+i<=mid){
                p+=i;
            }else{
                s++;
                p=i;
            }
        }
        return s<=k;
    }
}