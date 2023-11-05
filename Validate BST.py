# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n), n is no of nodes in tree
#SC: O(n)
#Recursive 
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):
                return False
            if root.val <= self.prev:
                return False
            self.prev = root.val
            return inorder(root.right)

        self.prev = -math.inf
        return inorder(root)

#TC: O(n), n is no of nodes in tree
#SC: O(n)
#Recursive post
class Solution(object):
    def isValidBST(self, root):
        self.flag = True
        
        def helper(root, mini, maxi):
            #base
            if root is None:
                return           
            #logic
            if maxi is not None and root.val >= maxi:
                self.flag = False
                
            if mini is not None and root.val <= mini:
                self.flag = False
            
            helper(root.left, mini, root.val)
            helper(root.right, root.val,maxi)
            
        helper(root, None, None)
        return self.flag

#Recursive pre
class Solution(object):
    def isValidBST(self, root):
        self.flag = True
        
        def helper(root, mini, maxi):
            #base
            if root is None:
                return           
            #logic

            helper(root.left, mini, root.val)
            helper(root.right, root.val,maxi)
            if maxi is not None and root.val >= maxi:
                self.flag = False
                
            if mini is not None and root.val <= mini:
                self.flag = False
            
        helper(root, None, None)
        return self.flag

#Recursive In
class Solution(object):
    def isValidBST(self, root):
        self.flag = True
        
        def helper(root, mini, maxi):
            #base
            if root is None:
                return           
            #logic

            helper(root.left, mini, root.val)
            if maxi is not None and root.val >= maxi:
                self.flag = False
                
            if mini is not None and root.val <= mini:
                self.flag = False
            helper(root.right, root.val,maxi)            
            
        helper(root, None, None)
        return self.flag

#Recursive without flag
class Solution(object):
    def isValidBST(self, root):
        
        def helper(root, mini, maxi):
            #base
            if root is None:
                return True           
            #logic

            if mini is not None and root.val <= mini:
                return False
            if maxi is not None and root.val >= maxi:
                return False
            
            left = helper(root.left, mini, root.val)
            right = helper(root.right, root.val,maxi)            
            return left and right
        
        return helper(root, None, None)
        
#Iterative        
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack, prev = [], -math.inf

        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            # If next element in inorder traversal
            # is smaller than the previous one
            # that's not BST.
            if root.val <= prev:
                return False
            prev = root.val
            root = root.right

        return True

#Print Up and down to understand traversal
#         def helper(self, root):
#             if root is None:
#                 return
#             helper(self, root.left)
#             print("Up")
#             print(root.val)
#             helper(self, root.right)
#             print("down")
#             print(root.val)
            
#         helper(self, root)


         