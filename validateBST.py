"""Approach 1:
Inorder traversal of the tree and maintain a flag globally to indicate if tree is invalid.
Return flag at the end.
TC O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.
SC O(N) for the space on the run-time stack
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    flag = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
            self.inorder(root)
            return self.flag
    
    def inorder(self, root: Optional[TreeNode]) -> None:
        if not root: return
        
        self.inorder(root.left)
        if self.prev and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
        if self.flag:
            self.inorder(root.right)

"""Approach 2:
Inorder traversal of the tree and inorder function returns boolean. If it reaches None node, return True
if prev >= current root, return False. Do same for left and right subtrees and finally return the `left && right`.
TC O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.
SC O(N) for the space on the run-time stack
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
            return self.inorder(root)
    
    def inorder(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
         
        left = self.inorder(root.left)
        
        if self.prev and self.prev.val >= root.val:
            return False
       
        self.prev = root
    
        right = self.inorder(root.right)
        return left and right