# Time Complexity: O(n)
# Space Complexity: O(1)
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None

        output = ListNode(preorder[0])
        x = inorder.index(preorder[0])
        output.left = self.buildTree(preorder[1:x+1], inorder[:x])
        output.right = self.buildTree(preorder[x+1:], inorder[x+1:])
        return output