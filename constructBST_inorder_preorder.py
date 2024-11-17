
"""
TC: O(n) iterating through n elements in array
SP: O(n) to create hashmap, worst case call stack space

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        indices = {k: i for i, k in enumerate(inorder)}
        self.pre_idx = 0
        def helper(l, r):
            if l>r:
                return None
            rootVal = preorder[self.pre_idx]
            rootIdx = indices[rootVal]
            root = TreeNode(rootVal)
            self.pre_idx+=1
            root.left = helper(l, rootIdx-1)
            root.right = helper(rootIdx+1, r)
            return root
        return helper(0, len(preorder)-1)
            
        