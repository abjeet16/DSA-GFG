class Solution {
    public static int[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        int arr[] = new int[n]; 
        arr[0] = 1;
        for(int i = 1 ; i < n ; i++){
            arr[i] = arr[i-1]*nums[i-1];
        }
        //System.out.println(Arrays.toString(arr));
        int post = 1;
        for(int i = n-1 ; i >= 0 ; i--){
            arr[i]*=post;
            post*=nums[i];
        }
		return arr;
    }
}
