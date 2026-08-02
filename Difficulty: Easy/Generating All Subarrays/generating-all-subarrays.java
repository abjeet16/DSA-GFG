// User function Template for Java
class Solution {
    public static List<List<Integer>> getSubArrays(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        for (int start = 0; start < arr.length; start++) {
            List<Integer> curr = new ArrayList<>();
            for (int end = start; end < arr.length; end++) {
                curr.add(arr[end]);
                res.add(new ArrayList<>(curr));
            }
        }

        return res;
    }
}