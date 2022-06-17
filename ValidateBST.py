#TC: O(n)
#SC: O(h) where h is the height of the tree
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
        self.prev=None
        self.flag=False

        def inorder(root):
            if root==None : return
            inorder(root.left)
                #print("up")
                #print(root.val)
            if self.prev!=None and self.prev.val>=root.val:
                self.flag=False
            self.prev=root
            inorder(root.right)
                #print("down")
                #print(root.val)
        self.flag=True
        inorder(root)
        return self.flag



#code using boolean recursive call
'''
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
        self.prev=None
        

        def inorder(root):
            if root==None : return True
            if inorder(root.left)==False: return False
                #print("up")
                #print(root.val)
            if self.prev!=None and self.prev.val>=root.val:
                return False
            self.prev=root
             
            return inorder(root.right)
                #print("down")
                #print(root.val)
       
        return inorder(root)
       
'''

#code using iterative solution

'''
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
        prev=None
        stack=[]
        while(len(stack)!=0 or root!=None):
            #inorder(root.left)
            while(root!=None):
                stack.append(root)
                root=root.left
            root=stack.pop()
            if(prev!=None and prev.val>=root.val):
                return False
            prev=root
            root=root.right
        return True
        
'''

#code using min and max technique
'''
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
        
        def helper(root,mini,maxi):
            #base
            if root==None: return True
            if mini!=None and mini>=root.val: return False
            if maxi!=None and maxi<=root.val: return False
            #logic
            left = helper(root.left,mini,root.val)
            right = helper(root.right,root.val,maxi)

            return left and right
        return helper(root,None,None)
       
'''
##code using min and max technique with code readability and default if left is not true will not check for right sub tree
'''
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
        
        def helper(root,mini,maxi):
            #base
            if root==None: return True
            if mini!=None and mini>=root.val: return False
            if maxi!=None and maxi<=root.val: return False
            #logic
            return helper(root.left,mini,root.val) and helper(root.right,root.val,maxi)
        return helper(root,None,None)
       
'''

        
            
        
        