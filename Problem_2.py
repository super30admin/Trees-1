"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(h) //h=height of the tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

finding the root of the tree first, which is the first element of the preorder array
then finding the index of root in inorder array, so as to divide the inorder array into two parts, left and right
then recursively dividing both the array based on the position of the root and constructing the tree

"""

# Inorder/Preorder traversal 

# Approach - 1


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
        if not preorder or not inorder:
            return None

        tree=TreeNode(preorder[0])
        root=inorder.index(preorder[0])

        tree.left=self.buildTree(preorder[1:root+1],inorder[:root])
        tree.right=self.buildTree(preorder[root+1:],inorder[root+1:])

        return tree


# Approach - 2

# hashmap - to reduce root search time to O(1)
# start,end pointers - to reduce time complexity arrised due to array copying

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.hmap={}
        self.idx=None
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None

        for i in range(len(inorder)):
            self.hmap[inorder[i]]=i
        start=0
        end=len(inorder)-1
        self.idx=0

        return self.helper(preorder,start,end)
    def helper(self, preorder,start,end):
        if start>end:
            return None
        rootVal=preorder[self.idx]
        root=TreeNode(rootVal)
        rootIdx=self.hmap[rootVal]
        self.idx+=1
        
        
        
        

        root.left=self.helper(preorder,start,rootIdx-1)
        root.right=self.helper(preorder,rootIdx+1,end)
        


        return root
    
