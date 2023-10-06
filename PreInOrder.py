# Time Complexity: O(n) 
# Space Complexity:  O(n)

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
        if preorder == None or len(preorder) == 0:
            return None
        rootIdx=0
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i

        inorderLeft = inorder[0:rootIdx]
        inorderRight = inorder[rootIdx+1:len(inorder)] 
        preorderLeft = preorder[1:len(inorderLeft)+1]
        preorderRight = preorder[len(inorderLeft)+1:len(preorder)]

        root.left = self.buildTree(preorderLeft,inorderLeft)
        root.right = self.buildTree(preorderRight,inorderRight)

        return root
        
