class Solution {
    public int findFinalValue(int[] nums, int k) {
        int bits = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k != 0) continue;
            nums[i] = nums[i] / k;
            if ((nums[i] & (nums[i] - 1)) == 0)
                bits |= nums[i];
        }
        int d = bits + 1;
        return k * (d & -d);
    }
}