class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0, prev=0;
        final int n=bank[0].length();
        for(String row : bank){
            int dev=0;
            for(int j=0; j<n; j++)
                dev+=(row.charAt(j)=='1'?1:0);
            if (dev>0){
                ans+=dev*prev;
                prev=dev;
            }   
        }
        return ans;
    }
}