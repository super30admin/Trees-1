# TC : O(N)
# SC : O(N)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        N = len(preorder)
        root = TreeNode(0)
        s, e = 0, N - 1
        nodes = [(root, s, e)]
        d = {inorder[i]: i for i in range(N)} 
        for i in range(N):
            curr, s, e = nodes.pop()
            curr.val = preorder[i]
            mid = d[curr.val]
            if mid < e:
                curr.right = TreeNode(0)
                nodes.append((curr.right, mid + 1, e))
            if s < mid:
                curr.left = TreeNode(0)
                nodes.append((curr.left, s, mid - 1))
        return root