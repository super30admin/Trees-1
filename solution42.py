#Time Complexity:O(n)
#Space Complexity:O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    dict ={}                                                                    #declaring a hash map
    idx=0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0:                                                    #Checking id input is empty
            return None
        for i in range(len(inorder)):                                           # initializing values in hashmap using the inorder array
            self.dict[inorder[i]]=i
        return self.helper(preorder,0,len(inorder)-1)
    
    def helper(self,preorder: List[int], start:int, end:int) -> TreeNode:
        if start>end:                                                           #if start is grater than end then return
            return None
        rootVal=preorder[self.idx]                                              #rootval will be assigned using the preorder at IDx'th index
        root=TreeNode(rootVal)                                                  #Creating the root node 
        self.idx+=1                                                             #increment the idx
        ridx=self.dict[rootVal]                                                 #obtain the rootval index from hashmap to find left and right subtrees
        root.left=self.helper(preorder,start,ridx-1)                            #Create left subtree
        root.right=self.helper(preorder,ridx+1,end)                             #Create right subtree
        return root                                                             #return the final tree formed.
       