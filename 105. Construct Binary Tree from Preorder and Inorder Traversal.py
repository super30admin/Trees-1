# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
 # Pre order gives the root and the inorder gives its corresponding right and left childern
 # A hashmap is used to save the space by helping in accesing the piovot index

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    hashmap = {}
    idx = 0
    def helper(self, prev, start, end):
        # base
        if start > end: return None    
        # logic
        rootValue = prev[self.idx]
        root = TreeNode(rootValue)
        self.idx += 1
        rightIdx = self.hashmap[rootValue] 
        root.left = self.helper(prev, start, rightIdx-1)
        root.right = self.helper(prev, rightIdx+1, end)
        return root
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0: return None
        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i
        return self.helper(preorder, 0, len(inorder)-1)