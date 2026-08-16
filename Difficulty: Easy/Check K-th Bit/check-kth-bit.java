class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        // Write your code here.
        int c = 0;
        while(n!=0){
            int rem = n%2;
            n/=2;
            if(k==c)return rem==1;
            c++;
        }
        return false;
    }
}