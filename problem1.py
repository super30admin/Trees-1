# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# property - inorder traversal of a binary search tree is always sorted
# use global variable for sorted check
# Time complexity  - O(N) - since we visit all the nodes of the tree
# Space complexity  - O(h) - height of the tree - 'h' can become 'n'(skewed tree) or 'log n'(balanced binary tree) depending on the tree 
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev=[float('-inf')]
        flag=[True]
        def dfs(root):
            #base
            if root==None:
                return
            #logic
            dfs(root.left)
            #root=stack.pop()
            if prev[0]>=root.val:
                flag[0]=False
            prev[0]=root.val
            dfs(root.right)
            #root=stack.pop()
            
        dfs(root)
        return flag[0]