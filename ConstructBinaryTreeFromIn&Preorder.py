#All TC on leetcode passed


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        #Here we get root from preorder 1st element. We find that root index in inorder array. Now we call buildTree function using the preorder left, right and inorderleft, right arrays.
        #Time complexity - O(n^2) where we have to find the index
        #Space complexity - O(n) where we have to perform recussive calls n times

        if not preorder or not inorder:
            return 

        root = TreeNode(preorder[0])
        idx = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:idx+1], inorder[:idx])
        root.right = self.buildTree(preorder[idx+1:], inorder[idx+1:])
        return root
        