#  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        return self.helper(preorder,inorder)

    def helper(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        
        mainroot = preorder[0]
        root = TreeNode(mainroot)

        rootIdx = -1
        for i in range(len(inorder)):
            if mainroot == inorder[i]:
                rootIdx = i
                break
        
        inleft = inorder[0:rootIdx]
        inright = inorder[rootIdx+1:len(inorder)]
        preleft = preorder[1:len(inleft)+1]
        preright = preorder[len(inleft)+1:len(preorder)]

        root.left = self.helper(preleft,inleft)
        root.right = self.helper(preright,inright)

        return root
    

# TC: O(n) and SC O(n)

    # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hm = {}
        for i in range (len(inorder)):
            hm[inorder[i]] = i
        
        return self.helper(preorder,hm,0,len(inorder)-1)
    
    def helper(self, preorder: List[int], hm, start, end) -> Optional[TreeNode]:

        if(start > end) or self.idx > len(preorder):
            return None
        
        mainroot = preorder[self.idx]
        self.idx+=1
        root = TreeNode(mainroot)
        
        rootIdx = hm.get(mainroot)
        
        root.left = self.helper(preorder,hm,start,rootIdx-1)
        root.right = self.helper(preorder,hm,rootIdx+1,end)

        return root
        