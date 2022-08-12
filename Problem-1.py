#  98. Validate Binary Search Tree
'''
Leetcode all test cases passed: Yes
Solution:
    def isValidBST(self, root):
        n is the no of nodes in the tree
        h is the height of tree 
        Space Complexity: O(h)
        Time Complexity: O(n)
'''
class Solution:
    def __init__(self):
        self.prev = None
        
    def inOrder(self,root):
        
        if root == None:
            return True
        
        if self.inOrder(root.left) == False:
            return False
        
        if self.prev != None and self.prev >= root.val:
            return False
        self.prev = root.val
        return self.inOrder(root.right)
        
    def isValidBST(self, root):
        return self.inOrder(root)
