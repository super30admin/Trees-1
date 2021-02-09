#TimeComplexity:O(N) 
#SpaceComplexity: Max Depth of Tree
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root==None:return True
        prev, stack=None,[]
        while root or stack:
            while root:
                stack.append(root)
                root=root.left
            root=stack.pop()
            while prev is not None  and root is not None and prev.val>=root.val: return False
            
            prev=root
            root=root.right
        return True
                

