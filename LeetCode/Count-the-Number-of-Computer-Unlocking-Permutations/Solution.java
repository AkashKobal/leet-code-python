class Solution {
    int mod = 1_000_000_007; 
    public int countPermutations(int[] complexity) {
        int first = complexity[0];
        for(int i=1; i<complexity.length; i++) {
            if(complexity[i] <= first) {
                return 0;
            }
        }
        return fact(complexity.length-1);
    }

    int fact(int n) {
        long res = 1;
        for(int i=2; i<=n; i++) {
            res = (res*i)%mod;
        }
        return (int)res;
    }
}