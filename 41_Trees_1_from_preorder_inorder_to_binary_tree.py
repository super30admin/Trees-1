#Time Complexity : O(nlogn) where n is the number of elements in preorder array, Did not get why
#Space Complexity : O(n) Did not get why
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

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
        if len(preorder)==0:
            return None
        #Forming the root of the tree.// We are sure that the 1st element of the preorder array will be the root
        root=TreeNode(preorder[0])
        
        index=-1
        for i in range(len(inorder)): #Getting 1st node 
            if inorder[i]==root.val:
                index=i
                break
        
        root.left=self.buildTree(preorder[1:index+1],inorder[0:index])
        root.right=self.buildTree(preorder[index+1:],inorder[index+1:])
        
        return root
        