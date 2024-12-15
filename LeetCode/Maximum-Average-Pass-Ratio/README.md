# Maximum Average Pass Ratio

Can you solve this real interview question? Maximum Average Pass Ratio - There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:


Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.


Example 2:


Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
Output: 0.53485

## Solution
```py
class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        # Function to calculate the gain in pass ratio for adding a student to a class
        def pass_ratio_gain(passi, totali):
            return (passi + 1) / (totali + 1) - passi / totali
        
        # Max-heap to store the gain, -gain because heapq is a min-heap by default
        heap = []
        for passi, totali in classes:
            gain = pass_ratio_gain(passi, totali)
            heappush(heap, (-gain, passi, totali))
        
        # Distribute the extra students
        for _ in range(extraStudents):
            # Pop the class with the maximum gain
            gain, passi, totali = heappop(heap)
            # Add one student to this class
            passi += 1
            totali += 1
            # Recalculate gain and push back into heap
            new_gain = pass_ratio_gain(passi, totali)
            heappush(heap, (-new_gain, passi, totali))
        
        # Calculate the final average pass ratio
        total_ratio = 0
        for _, passi, totali in heap:
            total_ratio += passi / totali
        
        return total_ratio / len(classes)
```
