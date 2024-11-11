# Prime Subtraction Operation

Can you solve this real interview question? Prime Subtraction Operation - You are given a 0-indexed integer array nums of length n.

You can perform the following operation as many times as you want:

 * Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].

Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

A strictly increasing array is an array whose each element is strictly greater than its preceding element.

 

Example 1:


Input: nums = [4,9,6,10]
Output: true
Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.

Example 2:


Input: nums = [6,8,11,12]
Output: true
Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.

Example 3:


Input: nums = [5,8,3]
Output: false
Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.

## Solution
```py
from typing import List
import bisect

class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        # Helper function to generate list of primes up to max_num using Sieve of Eratosthenes
        def sieve(max_num):
            is_prime = [True] * (max_num + 1)
            is_prime[0] = is_prime[1] = False
            for i in range(2, int(max_num**0.5) + 1):
                if is_prime[i]:
                    for j in range(i * i, max_num + 1, i):
                        is_prime[j] = False
            return [i for i in range(2, max_num + 1) if is_prime[i]]
        
        # Generate all primes up to 1000
        primes = sieve(1000)
        
        # Iterate over nums and apply the operation as needed
        prev = 0  # Initialize the previous number in the strictly increasing sequence
        for i in range(len(nums)):
            # Find the largest prime less than nums[i] that makes nums[i] - prime > prev
            pos = bisect.bisect_left(primes, nums[i])
            success = False
            
            # Try possible primes in reverse order to find the largest possible prime
            for j in range(pos - 1, -1, -1):
                prime = primes[j]
                if nums[i] - prime > prev:
                    nums[i] -= prime
                    success = True
                    break
            
            # If no valid prime found, check if nums[i] is still greater than prev without change
            if not success and nums[i] <= prev:
                return False
            
            # Update prev to current element's value
            prev = nums[i]
        
        # If we succeeded in making the array strictly increasing, return True
        return True
```
