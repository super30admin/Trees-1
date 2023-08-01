# Time Complexity : O(n), n is the number of nodes
# Space Complexity : O(H), height of the tree (for recursive stack)
# The first element in preorder list is the root of the binary tree. 
# Use a hash map to get the index of root node in the inorder array in O(1) time. 
# In the Inorder array, the things to the left correspond to the left sub tree and things to the right correspond to the right sub tree.
# Recursively call the helper function on the left and right sub portion of the array.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        hashmap={}
        idx=0

        for i in range(len(inorder)): #hashmap to get rootval index in inorder in O(1)
            hashmap[inorder[i]]=i
        

        def helper(preorder,start,end):
            nonlocal idx
            #base
            if start>end: return
            #logic
            rootval=preorder[idx]  #get elements in the order of preorder to build next root at each level 
            idx+=1
            root=TreeNode(rootval) #build the tree 
            rootidx=hashmap[rootval] #get rootval index in inorder 
            #here, you need to go left first, as in pre order, it's root-left-right and we are moving forward in the pre array
            root.left=helper(preorder,start,rootidx-1) #recruse left with start same and end at rootidx-1
            root.right=helper(preorder,rootidx+1,end)  #recruse right with start end and root at rootidx+1
            return root
        return helper(preorder,0,len(preorder)-1)


