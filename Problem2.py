#Time complexity of the code is O(n)
#Space complexity of the code is O(n)
#Problem ran successfully on leet code
#Faced no issues while coding

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        #Initializing required variables
        self.idx=0
        self.map={}
        #Iterating through the inorder array and creating a hashmap
        #such that search operaion can be O(1)
        for i in range(0,len(inorder)):
            self.map[inorder[i]]=i
        #We will be calling helper function which returns the final tree
        return self.helper(preorder,inorder,0,len(inorder)-1)
    
    def helper(self,preorder,inorder,start,end):
        #If the start index is greater than end index, it returns null
        if(start>end):
            return None
        #root value is at the first index in preorder array
        rootVal=preorder[self.idx]
        #incrementing self index at every step
        self.idx+=1
        #Creating a root node with rootVal as value
        root=TreeNode(val=rootVal)
        #rootindx is the place where the root value is present in the inorder array
        rootIdx=self.map[rootVal]
        #moving through the left hand side of the tree
        root.left=self.helper(preorder,inorder,start,rootIdx-1)
        #moving through the right hand side of the tree
        root.right=self.helper(preorder,inorder,rootIdx+1,end)
        #returning the final tree
        return root

