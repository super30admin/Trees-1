
#-----------Solution 1 : Perform Inorder Traversal and compare with prev node------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:

    def __init__(self):
        self.flag = True
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root):
            if root is None:
                return
            if self.flag :
                inorder(root.left)
            print(root.val)
            if self.prev is not None and root.val <= self.prev.val:
                self.flag = False
    
            self.prev = root

            if self.flag:
                inorder(root.right)
            return
        inorder(root)
        return self.flag


#-----------Solution 2 : Comapring with range of minimum and Maximum------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:

    def __init__(self):
        self.flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def isBST(root, minv, maxv):
            if root is None :
                return 
            if self.flag:
                isBST(root.left,minv,root.val)

            if root.val <= minv or root.val => maxv:
                self.flag = False
            
            if self.flag:
                isBST(root.right,root.val,maxv)
        
        isBST(root,float("-inf"),float("inf"))
        return self.flag


