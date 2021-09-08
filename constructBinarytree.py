# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC: O(2n*n) 2n for 'n' nodes
    SC: O(depth*2n) depth --> recursive stack, 2n --> arrays
    """

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        if len(preorder) == 0:
            return None

        root = TreeNode(preorder[0])
        index = 0

        # O(n) TC
        for i in range(len(inorder)):
            if root.val == inorder[i]:
                index = i
                break

        # O(n) TC
        preLeft = preorder[1: (1 + index)]
        preRight = preorder[(1 + index):]
        inLeft = inorder[0:index]
        inRight = inorder[(index + 1):]

        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root