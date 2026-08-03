class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int m = a.length , n = b.length;
        if(m>n)return kthElement(b,a,k);
        
        int low = 0 , high = m;
        
        while(low <= high){
            int c1 = (low+high)/2;
            int c2 = k-c1;
            
            if(c2<0){
                high = c1-1;
                continue;
            }
            if(c2>n){
                low = c1+1;
                continue;
            }
            
            int l1 = c1==0 ? Integer.MIN_VALUE : a[c1-1];
            int l2 = c2==0 ? Integer.MIN_VALUE : b[c2-1];
            int r1 = c1==m ? Integer.MAX_VALUE : a[c1];
            int r2 = c2==n ? Integer.MAX_VALUE : b[c2];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }else if(l1 > r2){
                high = c1-1;
            }else{
                low = c1+1;
            }
        }
        return -1;
    }
}