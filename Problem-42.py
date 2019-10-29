# valid BST- Leet code 98
# time complexity - O(N)
#space complexity -O(N)
# Approach - For the left node the maximum value changes, but the minimum remains constant. whereas, For right sub tree minimum value changes and maximum value remains constant. 


#recursive solution

class Solution(object):
    def isValidBST(self, root):
        return self.helper(root,float('-Inf'),float('Inf'))
        
    def helper(self,root,min,max):
        #edge case
        if (root==None): return True
        
        if (min!=float('-Inf')) and  (root.val<=min): return False
        if (max!=float('Inf')) and (root.val>=max): return False
        
        return self.helper(root.left,min,root.val) and self.helper(root.right,root.val,max)
    
    
    
    
    
# second approach using stacks. First we need to push all the left node elements into the stack and then you need to pop, using current and previous values we have to check the binary tree.

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #edge case 
        if root==None: return True
        stack =[]
        prev=None
        while (root!=None or stack!=[]):
            while (root!=None):
                stack.append(root)
                root=root.left
            root=stack.pop()
            if (prev!=None and root.val <=prev.val):return False
            prev=root
            root=root.right
        return True
        
        
        