# problem 2 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        root_val = preorder[0]
        root_val_idx = inorder.index(root_val)

        left_inorder = inorder[:root_val_idx]
        right_inorder = inorder[root_val_idx+1:]
        left_preorder = preorder[1:len(left_inorder)+1]
        right_preorder = preorder[len(left_inorder)+1:]
        node = TreeNode(root_val)
        node.left = self.buildTree(left_preorder,left_inorder)
        node.right = self.buildTree(right_preorder,right_inorder)
        return node
