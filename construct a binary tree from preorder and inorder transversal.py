# TC-O(n**2)
# SC-O(n**2)n=height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) = =0:
            return None
        root= TreeNode(preorder[0])

        index =-1
        for i in range(len(inorder)):
            if inorder[i ]== root.val:
                inde x =i
                break

        preleft= preorder[1:index +1]
        preright =preorder[inde x +1:len(preorder)]
        inleft =inorder[0:index]
        inright =inorder[inde x +1:len(inorder)]
        root.left =self.buildTree(preleft ,inleft)
        root.right =self.buildTree(preright ,inright)
        return root