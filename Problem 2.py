# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hashmap = {v:i for i,v in enumerate(inorder)}
        idx = [0] #global index for preorder
        
        def helper(preorder, st, end):
            if st > end: 
                return None

            root = TreeNode()
            root.val = preorder[idx[0]]
            idx[0] += 1

            root_idx_in_order = hashmap[root.val]

            root.left = helper(preorder, st, root_idx_in_order-1)
            root.right = helper(preorder, root_idx_in_order+1, end)

            return root
