# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity is O(n2), we are making n recursive calls, while copying a list in each call and searching for the index.
# Space Complexity is O(n2), we are making a copy of list in each recursive call.
# This can be optimized by using Hashmap to store indices.
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if(len(preorder) == 0 or len(inorder) == 0):
            return None
        root = TreeNode(preorder[0])
        index = inorder.index(preorder[0])
        #print(preorder[1:index+1],inorder[:index])
        root.left = self.buildTree(preorder[1:index+1],inorder[:index])
        root.right = self.buildTree(preorder[index+1:],inorder[index+1:])
        return root