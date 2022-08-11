# Time complexity: O(n)
# Space Complexity: O(H)   H is the height of the BST
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
        self.flag = True
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.inorder(root)
        return self.flag
    
    def inorder(self, root: Optional[TreeNode]):
        
        if not root:
            return
        
        self.inorder(root.left)
        print('UP '+str(root.val))
        #stack.pop() happens
        
        if self.prev != None and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
        
        if self.flag:
            self.inorder(root.right)
            print('Down '+str(root.val))
        #stack.pop() happens