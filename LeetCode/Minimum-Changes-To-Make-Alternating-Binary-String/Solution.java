class Solution {
    public int minOperations(String s) {
        int n = s.length();
        StringBuilder pat1 = new StringBuilder();
        StringBuilder pat2 = new StringBuilder();
        boolean one = false;

        for(int i = 0; i < n; i++){
            if(one) pat1.append('1');
            else pat1.append('0');
            one = !one;
        }

        one = true;
        for(int i = 0; i < n; i++){
            if(one) pat2.append('1');
            else pat2.append('0');
            one = !one;
        }

        int cnt1 = 0, cnt2 = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) != pat1.charAt(i)) cnt1++;
            if(s.charAt(i) != pat2.charAt(i)) cnt2++;
        }

        return Math.min(cnt1, cnt2);
    }
}