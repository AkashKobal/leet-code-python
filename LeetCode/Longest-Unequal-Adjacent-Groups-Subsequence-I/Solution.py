class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:

        prev=-1
        ans=[]
        for x,y in zip(words,groups):
            if y!=prev:
                prev=y
                ans.append(x)
        return ans

        
        
        
        

            
            
        
    
    
        
        
        