"""
Through obersavtion, we can see that the first element in preorder is the root and the index of the root in the
inorder will help us check the left and right child of the tree. This way a bigger problem is broken into smaller
steps and solved recursively. TC is o(n) and SC is O(1)"""
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        return root