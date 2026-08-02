class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int currXOR = 0;
        int res = 0;
        
        for(int i : arr){
            currXOR^=i;
            int target = currXOR^k;
            
            res+=map.getOrDefault(target,0);
            map.put(currXOR,map.getOrDefault(currXOR,0)+1);
        }
        return res;
    }
}