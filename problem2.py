"""
time:O(n) #recursion is called once for each TreeNode
space:O(n) #on recursive call stack
leet: Accepted
Problems: None
"""

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if len(inorder)!=0:
            print("in"+str(inorder))
            index = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[index])
            root.left = self.buildTree(preorder,inorder[0:index])
            root.right = self.buildTree(preorder,inorder[index+1:])
            return root
