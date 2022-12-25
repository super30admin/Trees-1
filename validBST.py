
# // Time Complexity : O (n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
## we try to do the inorder traversal and see if the current value is greater than the previous. In inorder we
## compute left then root then right. so at root stage we check the value. if it is not greater than previous we make
## our global variable flag as false. we also have a global variable prev and not a parameter in helper because
## in the recursive stack the value is not chnaged.
class solution:
    prev = None
    flag = True
    def validBST(self, root):
        self.helper(root)

        return self.flag
    
    def helper(self, root):
        if root == None:
            return 
        if not self.flag:
            return 
        self.helper(root.left)

        if self.prev != None and root.val < self.prev.val:
            self.flag = False
            return
        if not self.flag:
            return
        self.prev = root
        
        self.helper(root.right)

