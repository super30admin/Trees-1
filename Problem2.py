#Time Complexity :O(n)
#Space Complexity :O(h)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.rootId=0
        self.map={}
        for i in range(len(inorder)):
            self.map[inorder[i]]=i
        return self.helper(preorder,0,len(inorder)-1,0)

    def helper(self, preorder, start, end, id):
        if start>end:
            return None
        rootval=preorder[self.rootId]
        self.rootId+=1
        id=self.map.get(rootval)
        root=TreeNode(rootval)
        root.left=self.helper( preorder, start, id-1,id)
        root.right=self.helper( preorder, id+1, end,id)
        return root
