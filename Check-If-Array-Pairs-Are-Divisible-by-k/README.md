# Check If Array Pairs Are Divisible by k

Can you solve this real interview question? Check If Array Pairs Are Divisible by k - Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return true If you can find a way to do that or false otherwise.

 

Example 1:


Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
Output: true
Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).


Example 2:


Input: arr = [1,2,3,4,5,6], k = 7
Output: true
Explanation: Pairs are (1,6),(2,5) and(3,4).


Example 3:


Input: arr = [1,2,3,4,5,6], k = 10
Output: false
Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.

## Solution
```py
class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        remainder_count = [0] * k
        
        # Count frequencies of remainders
        for num in arr:
            remainder = num % k
            # Adjust remainder for negative numbers
            if remainder < 0:
                remainder += k
            remainder_count[remainder] += 1
        
        # Check pairs of remainders
        if remainder_count[0] % 2 != 0:
            return False  # The remainder 0 needs to pair with itself, so must be even
        
        # Check pairs for other remainders
        for i in range(1, (k // 2) + 1):
            if remainder_count[i] != remainder_count[k - i]:
                return False
        
        return True
```
