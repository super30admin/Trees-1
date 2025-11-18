# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
def helper(node,  inOrderList):
    if(node is None):
        return 
    helper(node.left, inOrderList)
    inOrderList.append(node.val)
    helper(node.right, inOrderList)

class Solution(object):
    def isValidBST(self, root):
        """
        Time complexity: O(n)
        Space : O(h) where h is height of tree
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        if not root:
            return True

        inOrderList =[]
        isBST = True
        helper( root, inOrderList)
        prev = inOrderList[0]
        for i in range(1, len(inOrderList)):
            if inOrderList[i] <= prev:
                isBST = False
            prev = inOrderList[i]
        return isBST