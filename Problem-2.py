# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# The first unused element in preorder is always the root of the current subtree.
# Inorder traversal is used to split the tree into left and right subtrees.
# Recursively build left and right subtrees using these boundaries.

# Definition for a binary tree node.
#
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.idx =0
        inorder_map = {val:i for i,val in enumerate(inorder)}
        start = 0
        return self.helper(preorder,start,len(inorder)-1,inorder_map)
    def helper(self, preorder, start, end, inorder_map):
        if start>end:
            return None
        
        root_val = preorder[self.idx]
        self.idx += 1
        root = TreeNode(root_val)
        root_idx = inorder_map[root_val]

        root.left = self.helper(preorder, start, root_idx-1, inorder_map)
        root.right = self.helper(preorder, root_idx+1, end, inorder_map)

        return root
