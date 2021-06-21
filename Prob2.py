#Time complexity: O(n)   
#Space complexity: O(n) for map
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        # Similar approach as brute force, just we have map to find the root loc in inorder
        self.inorderLoc = {}
        self.indexRoot = 0
        for idx,el in enumerate(inorder):
            self.inorderLoc[el] = idx
        def helper(preorder,start,end):
            #base
            if start > end:
                return None
            #logic
            # index to know what the next root is, because roots are ascendingly ordered in preorder
            rootVal = preorder[self.indexRoot]
            self.indexRoot += 1
            root = TreeNode(rootVal)
            rootIdx = self.inorderLoc[rootVal]
            root.left = helper(preorder,start, rootIdx-1)
            root.right = helper(preorder,rootIdx+1,end)
            return root
        return helper(preorder,0,len(inorder)-1)
        
        
#         Basic brute force solution
#         if len(preorder) ==0:
#             return None
#         root = TreeNode(preorder[0])
#         rootIn = -1
#         for idx,el in enumerate(inorder):
#             if el == root.val:
#                 rootIn = idx
#         preLeft = preorder[1:rootIn+1]
#         preRight = preorder[rootIn+1:]
#         inLeft = inorder[0:rootIn]
#         inRight = inorder[rootIn+1:]
#         root.left = self.buildTree(preLeft,inLeft)
#         root.right = self.buildTree(preRight,inRight)
        
#         return root