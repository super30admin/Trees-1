# TC: O(n) (visiting all nodes)
# SC: O(n) worst case (right/left skewed), O(logn) (balanced tree)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution: 
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = [None]
        
        def dfs(node):
            if node is None:
                return True
            if not dfs(node.left):
                return False
            print(node.val)
            if prev[0] is not None and prev[0].val >= node.val:
                return False
            prev[0] = node
            return dfs(node.right)
        return dfs(root)

                
