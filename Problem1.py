'''
1. For every node, check if the left node is less than the root and right node is greater than the root.
2. Start with the root node and check if the left subtree is a valid BST. Then check if the right subtree is a valid BST
3. If at any point the left node is greater than the root or right node is less than the root, return False 
4. If the left subtree and right subtree are valid BSTs, return True

TC: O(n)
SC: O(h) where h is the height of the tree
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.prev = None
        return self.checkValid(root,None,None)
        

    def checkValid(self,root: Optional[TreeNode],Min,Max) -> bool:
        if root == None:
            return True
        if ((Min != None and Min >= root.val) or (Max != None and Max <= root.val)):
            return False
        # Moving left
        case1 = self.checkValid(root.left,Min,root.val)
        # Moving right
        case2 = self.checkValid(root.right,root.val,Max)
        return case1 and case2

        

    
            
        


