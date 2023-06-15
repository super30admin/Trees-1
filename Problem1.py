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
    
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #Intializing the required variables
        self.prev=None
        self.flag=True
        #Calling the helper function with root as the argument
        self.helper(root)
        #returning the flag value as the output
        return self.flag
        
    def helper(self, root):
        #base case
        #If the root is None, we will return nothing
        if(root==None):
            return
        #logic
        #left
        #going towards the left side of the tree from current root
        self.helper(root.left)
        #Checking the conditions on prev
        if(self.prev!=None and self.prev.val>=root.val):
            #If the condition satisfies, we will set the flag to false
            #which means it is not valid binary search tree
            self.flag=False
        #seeting the root to the prev
        self.prev=root
        #right
        #going towards the right side of the tree from current root
        self.helper(root.right)