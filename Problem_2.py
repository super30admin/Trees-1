#
# @lc app=leetcode id=105 lang=python3
#
# [105] Construct Binary Tree from Preorder and Inorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity - O(n). We are not using any deep copy here and referencing the positions in the original array
Space Complexity - O(n) + O(h). 

This code works on leetcode
'''
class Solution:
    def __init__(self):
        self.idx = 0 #initialize index
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder)==0:
            return None #if empty preorder, return null
        # rootVal = preorder[0]
        # root = TreeNode(rootVal)
        # idx = -1
        # for i in range(len(inorder)):
        #     if inorder[i] == rootVal:
        #         idx = i
        # root.left = self.buildTree(preorder[1:idx+1], inorder[:idx])
        # root.right = self.buildTree(preorder[idx+1:], inorder[idx+1:])
        # return root
        imap = {}
        for i, n in enumerate(inorder):
            imap[n] = i #store the inorder positions in a map
        return self.helper(imap, 0, len(inorder)-1, -1, preorder) #map, start, end, rootIndex in inorder, preorder
    
    def helper(self, imap, start, end, rootIdx, preorder):
        if start > end:
            return None
        rootVal = preorder[self.idx] #get the current root val
        self.idx+=1 #increment idx
        rootIdx = imap.get(rootVal) #get the index of the root in inorder
        root = TreeNode(rootVal) #create the node
        root.left = self.helper(imap, start, rootIdx-1, rootIdx, preorder) #lhs of node will be start index, rootIndex - 1, rootIndex, preorder
        root.right = self.helper(imap, rootIdx+1, end, rootIdx, preorder) #rhs of node will be rootIndex + 1, end, rootIndex, preorder
        return root #return the root


        
# @lc code=end

