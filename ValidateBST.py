##### Using Recursion #####
###########################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity -> O(n)
# Space complexity -> O(h)
class Solution:
    prev = TreeNode(val = None)
    isValid = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return self.isValid
        
        self.helper(root)
        return self.isValid
            
    def helper(self, root):
        if root:
            self.helper(root.left)
            if self.prev.val != None and self.prev.val >= root.val:
                self.isValid = False
                return
            self.prev = root
            self.helper(root.right)



##### Using Iterative method #####
##################################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity -> O(n)
# Space complexity -> O(h)

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        stack, prev = [], None     
        while root or stack != []:
            while root:
                stack += [root]
                root = root.left
                
            root = stack.pop()
            if prev != None and root.val <= prev:
                return False
            prev = root.val
            root = root.right
            
        return True

            