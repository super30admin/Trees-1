# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n + h*2^h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inord_ixs = {}
        for ix,val in enumerate(inorder):
            inord_ixs[val] = ix
        
        cur_ix = [0]
        
        def array_to_tree(left, right):
            if left > right:
                return None
            
            root_val = preorder[cur_ix[0]]
            root = TreeNode(root_val)
            cur_ix[0] += 1
            root.left = array_to_tree(left, inord_ixs[root_val] - 1)
            root.right = array_to_tree(inord_ixs[root_val] + 1, right)

            return root
        
        return array_to_tree(0, len(preorder) - 1)
