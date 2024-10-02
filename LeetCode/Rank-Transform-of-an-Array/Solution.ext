class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        # Create a sorted list of the unique elements in arr
        sorted_unique = sorted(set(arr))
        
        # Create a dictionary mapping each element to its rank
        rank_dict = {num: rank + 1 for rank, num in enumerate(sorted_unique)}
        
        # Replace each element in the original array with its rank
        return [rank_dict[num] for num in arr]
