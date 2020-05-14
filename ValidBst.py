#Time Complexity : O(N) where N is number of Nodes
#Space Complexity: O(N) where N is number stored in stacks


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
        prev =None
        stack = []
        while(root!= None or len(stack) != 0):
            while(root!=None):
                stack.append(root)
                root = root.left
        
            root = stack.pop()
            if prev != None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
        
#Recursive Code:
        
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
        return self.helper(root,None,None)
    def helper(self,root,mins,maxs):
        if root ==None :
            return True
        if (maxs!=None and root.val >= maxs) or (mins!=None and root.val<=mins):
            return False
        return self.helper (root.left,mins,root.val) and self.helper(root.right,root.val,maxs)
    