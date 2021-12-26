
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    idx = 0
    indexes = {}
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """


        for i in range(0,len(inorder)):
            self.indexes[inorder[i]] = i

        return self.buildLeftRight(preorder,inorder,0,len(preorder)-1)



    def buildLeftRight(self,preorder,inorder,start,end):
        if (start>end):
            return None
        else:
            retNode = TreeNode()
            # print(self.idx)
            retNode.val = preorder[self.idx]
            self.idx += 1

            #get the index
            if retNode == None:
                return None
            elif start==end:
                return retNode
            else:
                idx_hashmap = self.indexes[retNode.val]
                retNode.left = self.buildLeftRight(preorder,inorder,start,idx_hashmap - 1)
                retNode.right = self.buildLeftRight(preorder,inorder,idx_hashmap + 1,end)

                return retNode

