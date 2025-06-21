
class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        # Count frequency
        char_freq = Counter(word)

        # Sort the frequencies
        freq_list = sorted(char_freq.values())
        total_chars = len(freq_list)
        min_deletions = float('inf')

        # Try each frequency as the base
        for i in range(total_chars):
            base_freq = freq_list[i]
            deletions = 0

            # Delete all characters with frequency < base
            for j in range(i):
                deletions += freq_list[j]

            # Delete excess characters where freq > base + k
            for j in range(i+1, total_chars):
                if freq_list[j] > base_freq + k:
                    deletions += freq_list[j] - (base_freq + k)

            min_deletions = min(min_deletions, deletions)

        return min_deletions