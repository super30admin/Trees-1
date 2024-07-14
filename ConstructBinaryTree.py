#// Time Complexity : O(n) 
# // Space Complexity : O(n)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Yes i was not able to get the pointers solution at first but got it.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        preorderIdx=0
        dicti = {}

        if len(preorder)==0:
            return None
        for i,j in enumerate(inorder):
            dicti[j] = i
        def helper(start,end):
            nonlocal preorderIdx
            if start>end: # If no elements are left
                return None
            rootVal=preorder[preorderIdx]
            preorderIdx+=1
            indexVal=dicti[rootVal]
            root=TreeNode(rootVal)


            root.left=helper(start,indexVal-1)
            root.right=helper(indexVal+1,end)
            
            return root
        return helper(0,len(preorder)-1)






        # if len(preorder) == 0:
        #     return None
        # rootval = preorder[0]
        # dicti = {}
        # for i,j in enumerate(inorder):
        #     dicti[j] = i
        # # print(dicti)
        # root = TreeNode(rootval)
        # rootind = dicti[rootval]
        # inorderleft = inorder[:rootind]
        # inorderright = inorder[rootind+1:]
        # preorderleft = preorder[1:len(inorderleft)+1] 
        # preorderright= preorder[len(inorderleft)+1:]
        # root.left = self.buildTree(preorderleft,inorderleft)
        # root.right = self.buildTree(preorderright,inorderright)
        # return root
        
# Approach:
# 1. Create a dictionary to store the index of the element in the inorder array. This will help
# in finding the left and right subtrees of the root node.
# 2. Create a helper function to build the tree. This function will take the start and end
# indices of the inorder array as arguments.
# 3. If the start index is greater than the end index, return None.
# 4. Get the root value from the preorder array and increment the preorder index.
# 5. Find the index of the root value in the inorder array using the dictionary.
# 6. Create a new TreeNode with the root value.   
# 7. Call the helper function recursively to build the left subtree with the start index and the
# index of the root value minus 1 as the end index.
# 8. Call the helper function recursively to build the right subtree with the index of the root
# value plus 1 as the start index and the end index.
# 9. Return the root node.
