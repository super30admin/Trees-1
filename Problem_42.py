# TC: O(n)
# SC: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, head, arr = []):
        if head is None:
            return
        self.inorder(head.left, arr)
        arr.append(head.val)
        self.inorder(head.right, arr)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        arr = []
        self.inorder(root, arr)

        for i in range(1, len(arr)):
            if arr[i - 1] >= arr[i]:
                return False
        return True

