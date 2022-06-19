#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. n for storing elements in the hashmap
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/JW2KxAHFqv8
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #defining the index for the inorder array and it is global because it is changed in the recursion part
    index= 0
    #defining the hashmap for storing the index of the inorder
    inorderMap ={}
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #null condition
        if len(preorder) == 0:
            return None
        #storing the value of inorder with there index in the hashmap
        for i in range(len(inorder)):
            val = inorder[i]
            self.inorderMap[val] = i
        """for index, val in enumerate(inorder):
                self.inorderMap[val]=index"""
        #calling the recursion for constructing the tree by sending the preorder list with the start and the end index
        return self.helper(preorder, 0,len(inorder)-1)
    
    def helper(self, preorder: List[int], startIndex : int, endIndex: int):
        #base conditon
        if startIndex> endIndex:
            return None
        #logic
        #taking the root value from the inorder index
        rootvalue = preorder[self.index]
        #incrementing inorder everytime the recursion function is called
        self.index +=1
        #each time creating the new node to put the current root
        root = TreeNode(rootvalue)
        #fetching the index value of the rootvalur from the hashmap of the inorderMap
        rootIndex = self.inorderMap[root.val]
        #calling for the left part
        root.left = self.helper(preorder, startIndex, rootIndex-1)
        #calling for the left part
        root.right = self.helper(preorder, rootIndex+1, endIndex)
        return root
