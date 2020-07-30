"""
Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Approach 1 (Brute Force):

1. we get the root element from preorder traversal i.e (preorder[0])
2. then we find the index of this root element in the inorder traversal
3. we construct 4 subarrays :
    preorderLeft - contains the elements in preorder traversal of left sub tree
    preorderRight - contains the elements in preorder traversal of right sub tree
    inorderLeft - contains the elements in inorder traversal of left sub tree
    inorderRight - contains the elements in inorder traversal of right sub tree
    
4. then call the same buildTree function with preorderLeft, inorderLeft to construct the left subtree 
5. then call the same buildTree function with preorderRight, inorderRight to construct the right subtree 

"""

# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        # Base case
        if (len(preorder)==0 or len(inorder)==0):
            return None
        
        #Logic
        rootVal = preorder[0]
        rootIndex = inorder.index(rootVal)
        rootNode = TreeNode(rootVal)
        
        leftLen = rootIndex
        rightLen = len(inorder)-rootIndex+1

        preorderLeft = preorder[1:leftLen+1]
        preorderRight = preorder[leftLen+1:]
        inorderLeft = inorder[0:rootIndex]
        inorderRight = inorder[rootIndex+1:]
        
        rootNode.left = self.buildTree(preorderLeft,inorderLeft)
        rootNode.right= self.buildTree(preorderRight,inorderRight)
        
        return rootNode
        
        
             
        
"""
Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Approach 2:

1. Intution : the preorder always gives the root of left and right sub tree if we just take the next elements of preorder
2. maintain a global variable idx which points to 0th element of preorder
3. maintain a global map with keys as elements of inorder and value as the index of the corresponding element
4. maintain 2 local variable start and end which point to the start and end of the inorder array initially
5. in the helper function get the root element with the help of global variable idx  and find the index of of the root in inorder with the help of the map
6. call the helper function to create left and right subtree by changing the start and end pointers

"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    idx =0
    map1 = {}
    
    def helper(self,preorder,inorder,start,end):
        
        if(self.idx == len(preorder) or start>end):
            return None
    
        rootIdx = self.map1[preorder[self.idx]]
        rootNode = TreeNode(preorder[self.idx])
        self.idx+=1
        
        rootNode.left = self.helper(preorder,inorder,start,rootIdx-1)
        rootNode.right = self.helper(preorder,inorder,rootIdx+1,end)
        
        return rootNode 
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if(len(preorder)==0 or len(inorder)==0):
            return None
        
        for i in range(len(inorder)):
            self.map1[inorder[i]]=i
        return self.helper(preorder,inorder,0,len(inorder)-1)