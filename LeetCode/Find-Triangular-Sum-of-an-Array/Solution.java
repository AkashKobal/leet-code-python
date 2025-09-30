class Solution {
    private int getMod10(int n, int k) {
        int[][] fast5 = {
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 2, 1, 0, 0 },
                { 1, 3, 3, 1, 0 },
                { 1, 4, 1, 4, 1 }};

        int[][] sunzi = {
                { 0, 6, 2, 8, 4 },
                { 5, 1, 7, 3, 9 }};

        String n2 = Integer.toString(n, 2);
        String k2 = Integer.toString(k, 2);
        while (k2.length() < n2.length())
            k2 = "0" + k2;

        String n5 = Integer.toString(n, 5);
        String k5 = Integer.toString(k, 5);
        while (k5.length() < n5.length())
            k5 = "0" + k5;

        int mod2 = 1;
        for (int i = 0; i < n2.length(); i++) {
            if (k2.charAt(i) == '1' && n2.charAt(i) == '0') {
                mod2 = 0;
                break;
            }
        }

        int mod5 = 1;
        for (int i = 0; i < n5.length(); i++)
            mod5 = (mod5 * fast5[n5.charAt(i) - '0']
                    [k5.charAt(i) - '0']) % 5;
        
        return sunzi[mod2][mod5];
    }

    public int triangularSum(int[] nums) {
        int n = nums.length - 1;
        int sum = 0;

        for (int k = 0; k <= n; k++) {
            int coeff = getMod10(n, k);
            sum = (sum + coeff * nums[k]) % 10;
        }

        return sum;
    }
}
