class Solution(object):
    def findWordsContaining(self, words, x):
        return [i for i, w in enumerate(words) if x in w]