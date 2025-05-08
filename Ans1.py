# Time Complexity :  O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach:  This code checks if a binary tree is a valid Binary Search Tree (BST) by ensuring that every node's value falls within an allowed range defined by its ancestors. The helper function checks if the current node's value is within (minVal, maxVal), then recursively validates the left subtree (updating maxVal to the current node's value) and the right subtree (updating minVal to the current node's value). If a node is None, it’s valid. If any node violates the BST property (e.g., left child ≥ parent or right child ≤ parent), the tree is invalid.

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)
    
    def helper(self, root, minVal, maxVal): 
        if root == None:
            return True
        
        if minVal != None and root.val <= minVal:
            return False
        
        if maxVal != None and root.val >= maxVal:
            return False
        
        return self.helper(root.left, minVal, root.val) and self.helper(root.right, root.val, maxVal)