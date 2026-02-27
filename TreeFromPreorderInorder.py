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
        :rtype: Optional[TreeNode]
        """
        if not preorder or not inorder:
            return None
        """
        rootVal = preorder[0]
        rootIdx = -1
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break
    
        root = TreeNode(rootVal)
        leftPre = preorder[1:rootIdx+1]
        rightPre = preorder[rootIdx+1:]
        leftIno = inorder[0:rootIdx]
        rightIno = inorder[rootIdx+1:]

        root.left = self.buildTree(leftPre, leftIno)
        root.right = self.buildTree(rightPre, rightIno)

        return root
        """

        self.idxMap = dict()
        for i in range(len(inorder)):
            self.idxMap[inorder[i]] = i

        self.treeRootIdx = 0

        def helper(preorder, start, end):
            if start > end:
                #Breached. The current Node is NULL.
                return None

            #First things first, let us get the root node.
            rootVal = preorder[self.treeRootIdx]
            rootIdx = self.idxMap[rootVal]
            self.treeRootIdx += 1
            root = TreeNode(rootVal)


            #Let us build the left and right child recursively.
            #for left child, start remains the same, but end is the rootIdx - 1
            root.left = helper(preorder, start, rootIdx - 1)

            #for right child, start would be rootIdx+1, end remains the same.
            root.right = helper(preorder, rootIdx + 1, end)

            return root

        return helper(preorder, 0, len(inorder)-1)

#TC: O(n)
#SC: O(1)