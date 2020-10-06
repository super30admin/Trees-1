"""
Name: Srinidhi 
Did it run on LC: Yes

Logic: 
Preorder is RootLeftRight which means we can get root information from 
preorder. inorder is LeftRootRight which mean when we know the exact position of
root, we can mark what position comes in left and what comes in right.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0 or len(inorder)==0:
            return None
        
        hashmap = {}
        
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i
        
        def helper(preorder,inorder,i,j):
            if i > j:
                return None
            
            val = preorder.popleft()
            root = TreeNode(val)
            
            index = hashmap[val]
            
            root.left = helper(preorder,inorder,i,index-1)
            root.right = helper(preorder,inorder,index+1,j)
            
            return root
        
        n = len(preorder)
        root = helper(collections.deque(preorder),inorder,0,n-1)
        return root