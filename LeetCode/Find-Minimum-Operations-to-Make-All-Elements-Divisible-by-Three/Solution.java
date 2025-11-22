class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        
        for (int x : nums) {
            if (x % 3 != 0) {
                operations++;
            }
        }
        
        return operations;
    }
}