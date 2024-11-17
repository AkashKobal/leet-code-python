# Maximum Swap

Can you solve this real interview question? Maximum Swap - You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

 

Example 1:


Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.


Example 2:


Input: num = 9973
Output: 9973
Explanation: No swap.

```py
class Solution:
    def maximumSwap(self, num: int) -> int:
        # Convert number to list of digits (as characters)
        num_str = list(str(num))
        n = len(num_str)
        
        # last[i] will store the index of the largest digit from i to end
        last = [0] * n
        last[-1] = n - 1  # last element is itself the largest for its range

        # Fill the last array
        for i in range(n - 2, -1, -1):
            if num_str[i] > num_str[last[i + 1]]:
                last[i] = i
            else:
                last[i] = last[i + 1]

        # Try to find the first place where a swap would be beneficial
        for i in range(n):
            if num_str[i] != num_str[last[i]]:
                # Swap the current digit with the largest one found later
                num_str[i], num_str[last[i]] = num_str[last[i]], num_str[i]
                # Return the new number after the swap
                return int(''.join(num_str))
        
        # No swap was made, return the original number
        return num
```
