class Solution:
    def answerString(self, word: str, n: int) -> str:
        m=len(word)-n+1 # splits to be done with m length 
        if n==1: # if only one split we can do total word is taken 
            return word
# else check all m length splits and gind max in them 
        return max(word[i:i+m] for i in range(len(word)))