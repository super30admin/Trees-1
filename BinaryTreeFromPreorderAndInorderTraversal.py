
# Recursive Approach without dictionary
# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder)==0:
            return None
        
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        rootIdx = -1
        # for Loop for going through the  nodes
        for i in range(len(inorder)):
            if rootVal == inorder[i]:
                rootIdx = i
                break
                
        inLeft = inorder[0: rootIdx]
        preLeft = preorder[1:rootIdx+1]
        inRight = inorder[rootIdx+1:len(inorder)]
        preRight = preorder[rootIdx+1:len(preorder)]
        
        root.left = self.buildTree(preLeft,inLeft)
        root.right = self.buildTree(preRight,inRight)
        
        return root


# Iterative Approach with dictionary
# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :

# Definition for a binary tree node.
class Solution:
    hMap = dict()
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder)==0:
            return None
        self.hMap = {}
        for i in range(len(inorder)):
            self.hMap[inorder[i]] = i
        
        return self.helper(preorder, 0, len(inorder)-1)
    
    def helper(self, preorder, start, end):
        
        # base
        if start > end:
            return None
        # logic
        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        # root idx in my inorder
        rootIdx = self.hMap.get(rootVal)
        root.left = self.helper(preorder, start,  rootIdx-1)
        root.right = self.helper(preorder, rootIdx+1, end)   
            
        return root
        
        
        
        
    
        
       



