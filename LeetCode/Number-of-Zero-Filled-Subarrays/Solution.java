class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int n = nums.length,curr = 0;
        for(int i=0;i<n;i++)
        {
            if(nums[i] == 0)
            {
                curr++;
            }
            else
            {
                ans += (1L * curr*(curr+1)/2);
                curr = 0;
            }
        }
        ans += (1L * curr*(curr+1)/2);
        return ans;
    }
}