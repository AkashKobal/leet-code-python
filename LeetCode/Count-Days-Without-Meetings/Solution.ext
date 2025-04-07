class Solution:
    def countDays(self, days: int, meetings: list[list[int]]) -> int:
        today = 0
        
        for i, j in sorted(meetings, key=lambda x: x[0]):
            if j <= today:
                continue
            elif i > today:
                days -= j - i + 1
            else:
                days -= j - today
            today = j
            
        return days