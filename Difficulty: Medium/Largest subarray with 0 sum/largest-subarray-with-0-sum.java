class Solution {
    int maxLength(int arr[]) {
        // code here
         HashMap<Integer,Integer> map = new HashMap<>();
         map.put(0,-1);
         int res = 0;
         int sum = 0;
         for(int i = 0 ; i < arr.length ; i++){
             sum+=arr[i];
             res = Math.max(res,i-map.getOrDefault(sum,i));
             map.putIfAbsent(sum,i);
         }
         return res;
    }
}