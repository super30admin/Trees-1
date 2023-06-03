# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # Submitted successfully
        # TC = O(n) for recursive calls
        # SC = O(n) for recursive stack

        # base case
        if len(postorder) == 0:
            return None

        # root is at last index in postorder
        self.idx = len(postorder) - 1

        hmap = {}
        for i in range(len(inorder)):
            hmap[inorder[i]] = i

        def build(inorder, postorder, left, right):

            # termination condition
            # after 0, negative index should be stopped as it is valid
            if left > right or self.idx == -1:
                return None

            rootVal = postorder[self.idx]
            root = TreeNode(rootVal)
            self.idx -= 1

            ridx = hmap[rootVal]

            # IMPORTANT - ORDER MATTERS. RIGHT SHOULD BE PROCESSED BEFORE LEFT AS IT IS POSTORDER
            root.right = build(inorder, postorder, ridx + 1, right)
            root.left = build(inorder, postorder, left, ridx - 1)

            return root

        return build(inorder, postorder, 0, len(inorder) - 1)