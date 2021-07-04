# Time Complexity :O(n^2)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        # while there is inorder
        if inorder:
            #root is first one in pre-order
            root = TreeNode(preorder.pop(0))
            # find index of root in inorder
            index = inorder.index(root.val)
            # the left part of the inorder is the left tree
            root.left = self.buildTree(preorder,inorder[:index])
            # the right part of the inorder is the right tree
            root.right = self.buildTree(preorder,inorder[index+1:])
            #return root
            return root