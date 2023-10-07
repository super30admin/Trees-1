# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# time complexity: O(n) n when we iterate through inorder to create hash map
#space complexity: O(n+h) n is creation of hashMap and h is from recursion stack in helper
class Solution(object):
    def buildTree(self, preorder, inorder):
        self.map = {}
        self.index = 0

        if len(preorder) == 0 or len(inorder)==0:
            return
        for i in range(0,len(inorder)):
            self.map[inorder[i]] = i

        return self.helper(preorder, 0, len(inorder)-1)

    def helper(self, preorder, start, end):
        if(start>end):
            return None
        #to get root value that is first value from preorder    
        rootVal = preorder[self.index]
        self.index+= 1    
        #
        root = TreeNode(rootVal)
        #getting index where root value exists in inorder function 
        rootIndex = self.map[rootVal]
          #by using rootIndex travrse through preorder to create and right subtree 
        root.left = self.helper(preorder, start, rootIndex-1)
        root.right = self.helper(preorder, rootIndex+1, end)
        return root
         

        
