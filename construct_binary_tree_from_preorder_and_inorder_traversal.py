# Time Complexity: O(n) where n is the length of the list
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder) == 0:
            return None
        d = dict()
        self.index = 0
        for i,val in enumerate(inorder):
            d[val] = i
        def helper(preorder,inorder,d,low,high):
            if low > high or self.index == len(inorder):
                return None
            root = TreeNode(preorder[self.index])
            self.index += 1
            break_index = d[root.val]
            
            root.left =  helper(preorder,inorder,d,low,break_index-1)
            root.right =  helper(preorder,inorder,d,break_index+1, high)
            return root
            
            
            
        return helper(preorder,inorder,d,0,len(preorder)-1)