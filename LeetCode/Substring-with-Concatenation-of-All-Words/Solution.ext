from collections import defaultdict

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []
        
        word_count = defaultdict(int)
        for word in words:
            word_count[word] += 1
        
        substr_len = len(words) * len(words[0])
        word_len = len(words[0])
        result = []
        
        for i in range(len(s) - substr_len + 1):
            seen = defaultdict(int)
            for j in range(i, i + substr_len, word_len):
                word = s[j:j+word_len]
                if word in word_count:
                    seen[word] += 1
                    if seen[word] > word_count[word]:
                        break
                else:
                    break
            else:
                result.append(i)
        
        return result
