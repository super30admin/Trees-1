"""
// Time Complexity : mentioned in code
// Space Complexity : mentioned in code
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

--> basis of the solution is that, the inorder traversal of bst is always in ascending order.
--> used a prev pointer to keep track of the node immediately before a particular node
--> as soon as there is a violation, return False

// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
"""
Time complexity: o(n), n->number of nodes
Space complexity: o(h), where h is the height of BST
"""
class Solution(object):
    prev = None # GLOBAL,will keep check of the node right before certain node, since inorder traversal of valid bst is in ascending order, prev should always be smaller
    def inorder(self, root):
        #base case
        if root == None: #if entire path has been traversed, return true
            return True
        
        if not self.inorder(root.left): #if left path is invalid
            return False
        
        if self.prev != None and root.val <= self.prev: #if prev is greater than current value then return False
            return False
        
        self.prev = root.val #update prev
        
        return self.inorder(root.right) #recursive call for right child
    
    
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        return self.inorder(root)
        """
        Iterative with prev pointer
        Time complexity: o(n), n->number of nodes
        Space complexity: o(h), where h is the height of BST

        if not root:
            return True

        st = []
        
        prev = None
        
        cur = root
        res = []
        while cur or st: 
            while cur:
                
                st.append(cur) #keep going till we traverse the entire left side
                cur = cur.left
            
            cur = st.pop() #get the current node
            
            if prev != None:
                if prev >= cur.val: #compare with prev 
                    return False
                
            prev = cur.val
            #res.append(cur.val)
            cur = cur.right # explore right child
        
        #for i in range(0,len(res)-1):
         #   if res[i]>=res[i+1]:
          #      return False
        return True
        """
        