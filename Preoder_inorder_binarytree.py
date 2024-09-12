#Time Complexity:O(n)
#Space Complexity:O(n)
#  1 element of preorder is the root of the tree and the elements left of the that element
# in inorder is left part of tree and the right of that element in inorder is the right part
# of tree
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if inorder:
            i=inorder.index(preorder.pop(0))
            root=TreeNode(inorder[i])
            root.left=self.buildTree(preorder,inorder[0:i])
            root.right=self.buildTree(preorder,inorder[i+1:])
            return root