class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        freq=Counter(digits)
        ans=[]
        for x in range(100, 1000, 2):
            x0, x1, x2=x%10, (x//10)%10, x//100
            freq[x0]-=1
            freq[x1]-=1
            freq[x2]-=1
            if freq[x0]>=0 and freq[x1]>=0 and freq[x2]>=0:
                ans.append(x)
            freq[x0]+=1
            freq[x1]+=1
            freq[x2]+=1
        return ans
        
        