# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        idx=0
        hm= {value:idx for idx, value in enumerate(inorder)}
        def helper(left, right):
            nonlocal idx
             if left>right:
                return
            
            curr= preorder[idx]
            node= TreeNode(curr)
            idx+=1

            if left==right:
                return node

            in_ind= hm[curr]
            node.left = helper(left, in_ind-1)
            node.right= helper(in_ind+1,right)

            return node

        return helper(0, len(inorder)-1)
            
        