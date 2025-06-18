class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        a=[] # list to return answer
        n=len(nums)
        nums.sort() #nums are sorted
        for i in range(0,n-2,3): #loop only take three consecutive 
            if nums[i+2]-nums[i]>k:
                return [] # if any three consecutive not satisfies return empty
            a.append(nums[i:i+3]) # else take three into answer
        return a # return the answer