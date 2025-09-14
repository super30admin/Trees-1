# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
""" 
Time Complexity: O(N) 

Space Complexity: O(H) -> H = Height of the tree(varies from logn to N depending on the tree)

"""

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.prev = None
        def helper(node): 
            if not node: 
                return 

            helper(node.left)

            if self.prev != None and self.prev.val >= node.val: 
                self.flag = False

            if self.flag:
                self.prev = node
                helper(node.right)

        helper(root)
        return self.flag

