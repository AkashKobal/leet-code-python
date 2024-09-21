# Largest Number

Can you solve this real interview question? Largest Number - Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:


Input: nums = [10,2]
Output: "210"


Example 2:


Input: nums = [3,30,34,5,9]
Output: "9534330"

## Solution
```py
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        # Convert integers to strings
        array = list(map(str, nums))
        
        # Custom sorting with a lambda function
        array.sort(key=lambda x: x*10, reverse=True)
        
        # Handle the case where the largest number is "0"
        if array[0] == "0":
            return "0"
        
        # Build the largest number from the sorted array
        largest = ''.join(array)
        
        return largest
```
