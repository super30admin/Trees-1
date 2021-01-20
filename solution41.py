class Solution:
    prev=None                                               #initializing the global variabe prev to hold the previous node
    def isValidBST(self, root: TreeNode) -> bool:           
        return self.inorder(root)                           #caling the inorder function for root
        
    def inorder(self,root:TreeNode)->bool:
        if root==None:                                      # if the root is Null node return True
            return True
        if (self.inorder(root.left)==False):                #if the inorder of left subtree s false return false
            return False
        if(self.prev!=None and self.prev.val>=root.val):    # if the previous node is not empty and its value is greater than current node value
            return False                                    #return False
        self.prev=root                                      #update the previous node 
        return self.inorder(root.right)                     #return the boolean value after checking the right subtree