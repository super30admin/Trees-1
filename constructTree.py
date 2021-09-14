# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def construct_tree(left,right):
            nonlocal ind_pre
            if left > right:
                return None
            # element at ind_pre would be the root
            val_root = preorder[ind_pre]
            root = TreeNode(val_root)
            ind_pre+=1
            #construct left and right subtrees
            root.left = construct_tree(left,inorder_hash[val_root]-1)
            root.right = construct_tree(inorder_hash[val_root]+1,right)
            return root
        ind_pre = 0
        inorder_hash = {}
        #hashmap to store value : index pairs from inorder
        for ind,val in enumerate(inorder):
            inorder_hash[val] = ind
        return construct_tree(0,len(preorder)-1)
