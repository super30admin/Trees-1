#Time Complexity - O(n * n)
#Space Complexity - O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        dict = {}
        for x in range(len(inorder)):
            dict[inorder[x]] = x
        
        index = 0
            
        def helper( start, end):
            nonlocal index
            if start > end :
                return None
        
            newnode = TreeNode(preorder[index])
            index += 1
            newnode.left = helper(start, dict[newnode.val] - 1)
            newnode.right = helper(dict[newnode.val] + 1, end)
            return newnode
        
        return helper(0, len(inorder) - 1)
    
