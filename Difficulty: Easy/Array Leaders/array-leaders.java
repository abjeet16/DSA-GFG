class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int cm = arr[n-1];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(cm);
        for(int i = n-2;i>=0;i--){
            if(arr[i]>=cm){
                cm = arr[i];
                res.add(cm);
            }
        }
        Collections.reverse(res);
        return res;
    }
}