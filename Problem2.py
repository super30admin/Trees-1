# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder): #T.C -> O(N) , S.C->O(N)
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        self.idx = 0
        self.map = {}

        for i in range (len(inorder)):
            self.map[inorder[i]]=i

        return self.helper(preorder,0,len(preorder)-1)

    def helper(self,preorder,start,end):

        if(start>end):
            return None

        rootVal = preorder[self.idx]
        self.idx+=1
        rootIdx = self.map[rootVal]

        root = TreeNode(rootVal)

        root.left = self.helper(preorder,start,rootIdx-1)
        root.right = self.helper(preorder,rootIdx+1,end)

        return root
