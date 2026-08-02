class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        int m = a.length, n = b.length;

        while (i < m && j < n) {

            // Skip duplicates in a
            while (i > 0 && i < m && a[i] == a[i - 1]) i++;

            // Skip duplicates in b
            while (j > 0 && j < n && b[j] == b[j - 1]) j++;

            if (i >= m || j >= n) break;

            if (a[i] < b[j]) {
                res.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                res.add(b[j]);
                j++;
            } else {
                res.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < m) {
            if (i == 0 || a[i] != a[i - 1])
                res.add(a[i]);
            i++;
        }

        while (j < n) {
            if (j == 0 || b[j] != b[j - 1])
                res.add(b[j]);
            j++;
        }

        return res;
    }
}