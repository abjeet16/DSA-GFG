// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        map.put(0,-1);
        for(int i  = 0 ; i < arr.length ; i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                int j = map.get(sum-k);
                res = Math.max(res,i-j);
            }
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}