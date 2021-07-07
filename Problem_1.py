# Runs on Leetcode
# Time complexity: O(n) - visits each nodes exactly once
# Memory complexity: O(1)

'''

1) Let minimum be -infinity and maximum be +infinity

2) In a binary search tree, for all nodes to the left of root node, minimum will be -infinity and maximum will be value of 
   root node 
  
3) In a binary search tree, for all nodes to the right of root node, maximum will be infinity and minimum will be value of 
   root node 

4) If either of 2 or 3 fails, the given is tree is not a binary search tree.

5) If we reach till leaf of tree and the conditions don't fail, It is a Binary Search Tree

'''

class Solution:
    def isValidBST(self,root):
        return self.helper(root,float('-inf'),float('inf'))
    
    def helper(self,root,Min,Max):
        #edge case
        if not root:
            return True
        if root.val <= Min or root.val >= Max:
            return False
        return self.helper(root.left,Min,root.val) and self.helper(root.right,root.val,Max)
