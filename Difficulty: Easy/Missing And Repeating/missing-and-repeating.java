class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        boolean[] seen = new boolean[arr.length+1];
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i : arr){
            if(seen[i])res.add(i);
            seen[i]=true;
        }
        for(int i = 1 ; i < seen.length ; i++){
            if(!seen[i]){
                res.add(i);
                break;
            }
        }
        return res;
    }
}
