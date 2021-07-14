# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        #Recursive
        
        def treeHelper(preorder,inorder):
            if len(preorder)==0 or len(inorder)==0:
                return None
            rootval=preorder[0]
            root=TreeNode(rootval)
            
            rootininorder=inorder.index(rootval, 0, len(inorder))
           
            root.left=treeHelper(preorder[1:rootininorder+1],inorder[:rootininorder])
            root.right=treeHelper(preorder[rootininorder+1:],inorder[rootininorder+1:])
            return root
        return treeHelper(preorder,inorder)
       #Time O(n^2)
       #Space O(n^2)
       #https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
