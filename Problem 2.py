# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder, inorder):

        # if preorder does not exist return null
        if not preorder or not inorder:
            return None

        # if preorder exists, root=preorder[0]
        root = TreeNode(preorder[0])

        # now find the index of root in inorder
        index=inorder.index(preorder[0])
        #for i in range(len(inorder)):
         #   if inorder[i] == root.val:
          #      index = i
           #     break

        # new preLeft is in range(1,index+1)
        preLeft = preorder[1:index + 1]

        # new preRight is in range(index+1,len(preorder))
        preRight = preorder[index + 1:len(preorder)]

        # new inRight is in range(0,index)
        inLeft = inorder[0:index]

        # new inRight is in range(index+1,len(inorder))
        inRight = inorder[index + 1:len(inorder)]

        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root

TC:O(n)
SC:O(n)