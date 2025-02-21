# Find Elements in a Contaminated Binary Tree

Can you solve this real interview question? Find Elements in a Contaminated Binary Tree - Given a binary tree with the following rules:

 1. root.val == 0
 2. For any treeNode:
    a. If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
    b. If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2

Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:

 * FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
 * bool find(int target) Returns true if the target value exists in the recovered binary tree.

 

Example 1:

[https://assets.leetcode.com/uploads/2019/11/06/untitled-diagram-4-1.jpg]


Input
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
Output
[null,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1]); 
findElements.find(1); // return False 
findElements.find(2); // return True 

Example 2:

[https://assets.leetcode.com/uploads/2019/11/06/untitled-diagram-4.jpg]


Input
["FindElements","find","find","find"]
[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
Output
[null,true,true,false]
Explanation
FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
findElements.find(1); // return True
findElements.find(3); // return True
findElements.find(5); // return False

Example 3:

[https://assets.leetcode.com/uploads/2019/11/07/untitled-diagram-4-1-1.jpg]


Input
["FindElements","find","find","find","find"]
[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
Output
[null,true,false,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
findElements.find(2); // return True
findElements.find(3); // return False
findElements.find(4); // return False
findElements.find(5); // return True

## Solution
```py
class FindElements:
    def __init__(self, root: TreeNode):
        self.values = set()
        
        def recover(node, val):
            if not node:
                return
            node.val = val
            self.values.add(val)
            recover(node.left, 2 * val + 1)
            recover(node.right, 2 * val + 2)
        
        recover(root, 0)
    
    def find(self, target: int) -> bool:
        return target in self.values
```
