# TC = O(nk)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Base case
        if len(preorder) < 1 or len(inorder) < 0:
            return None

        # Logic
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])  # O(1) to get the first index
        root.left = self.buildTree(
            preorder[1 : mid + 1], inorder[0:mid]
        )  # O(k) to build the slicing of the list
        root.right = self.buildTree(
            preorder[mid + 1 :], inorder[mid + 1 :]
        )  # O(k) to build the slicing of the list

        return root
