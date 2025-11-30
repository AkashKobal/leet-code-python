1class Solution {
2
3    public int minSubarray(int[] nums, int p) {
4        int n = nums.length;
5        int totalSum = 0;
6
7        // Step 1: Calculate total sum and target remainder
8        for (int num : nums) {
9            totalSum = (totalSum + num) % p;
10        }
11
12        int target = totalSum % p;
13        if (target == 0) {
14            return 0; // The array is already divisible by p
15        }
16
17        // Step 2: Use a hash map to track prefix sum mod p
18        HashMap<Integer, Integer> modMap = new HashMap<>();
19        modMap.put(0, -1); // To handle the case where the whole prefix is the answer
20        int currentSum = 0;
21        int minLen = n;
22
23        // Step 3: Iterate over the array
24        for (int i = 0; i < n; ++i) {
25            currentSum = (currentSum + nums[i]) % p;
26
27            // Calculate what we need to remove
28            int needed = (currentSum - target + p) % p;
29
30            // If we have seen the needed remainder, we can consider this subarray
31            if (modMap.containsKey(needed)) {
32                minLen = Math.min(minLen, i - modMap.get(needed));
33            }
34
35            // Store the current remainder and index
36            modMap.put(currentSum, i);
37        }
38
39        // Step 4: Return result
40        return minLen == n ? -1 : minLen;
41    }
42}