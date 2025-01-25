############# Validate Binary Search tree ############

# Time Complexity : O(n)
# Space Complexity : O(h) where h is height
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Perform a inorder traversal and check if the prev element is greater than current then not valid otherwise valid

class Solution:
    
    def __init__(self):
        self.prev = None
    
    def inorder(self, root):
        if not root:
            return True
        if not self.inorder(root.left):
            return False
        if self.prev and root.val <= self.prev.val:
            return False
        self.prev = root.val
        return self.inorder(root.right)
        
    
    def validate_bst(self,root):
        return self.inorder(root)







