# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    """Time complexity-O(n) as we are using hashmap for inorder list
    Space complexity-O(n) as using hashmap as auxilary datastruct"""
    def __init__(self):
        self.indx=0
        self.inordermap=dict()
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return 
        for i in range(len(inorder)):
            self.inordermap[inorder[i]]=i          
        return self.helper(preorder, 0, len(inorder)-1)
    
    def helper(self, preorder, start, end):
        if start>end or self.indx>len(preorder)-1:
            return
        rootVal=preorder[self.indx]
        root=TreeNode(rootVal)
        self.indx+=1
        root.left=self.helper(preorder, start, self.inordermap[rootVal]-1)
        root.right=self.helper(preorder, self.inordermap[rootVal]+1, end)
        return root
                
        
        
       
        
        # if not preorder:
        #     return None
        # rootval=preorder[0]
        # root = TreeNode(rootval)
        # inorderRootIndex=0
        # for i in range(len(inorder)):
        #     if inorder[i]==rootval:
        #         inorderRootIndex=i
        #         break
        # leftpre=preorder[1:inorderRootIndex+1]
        # rightpre=preorder[inorderRootIndex+1:len(preorder)]
        # leftin=inorder[:inorderRootIndex]
        # rightin=inorder[inorderRootIndex+1:len(inorder)]
        # root.left=self.buildTree(leftpre, leftin)
        # root.right=self.buildTree(rightpre, rightin)
        # # print(root)
        # return root
    
    """Naive approach
    Time complexity-O(n^2) as we are looping over the elements present in inorder list in each recursion to get current root index
    space complexity-O(n^2) as we are creating O(n) extra space at each node(creating 4 different arrays in each recursion)"""
    
    
    
        
                
            
        