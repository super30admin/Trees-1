# Time Complexity : O(n), n is the number of nodes
# Space Complexity : O(H), height of the tree (for recursive stack)
# In method 2- we can have local min and max range varibales for each node and update them depending on the direction.
# If moving left, change max limit to root and if moving right, change min limit to root. If at any point not in the range return False


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        # Method 1 - Pure recursion
        # Perform an inorder trversal and return False if the elements are not in ascending order. Maintain a prev pointer to always point to the previous node in the graph
        # self.flag=True
        # self.prev=None
        
        # def inorder(root):
        #     if root==None:
        #         return 
        #     if self.flag: #to avoid unnecessary traversal after flag is False
        #         inorder(root.left)
        #     if self.prev and self.prev.val>=root.val:
        #         self.flag=False
        #     self.prev=root
        #     if self.flag: #to avoid unnecessary traversal after flag is False
        #         inorder(root.right)
        # inorder(root)
        # return self.flag
        
        
        #Method 2 - Using range of numbers
        #Below, is actually, pre-order traversal. Here, we are checking value within range and not about order of iteration. So, all 3 In,Pre and Post order traversal will work.
        self.flag=True
        def inorder(root,min,max):
            #base
            if root==None:
                return 
            if min!=None and root.val<=min:
                self.flag=False
            if max!=None and root.val>=max:
                self.flag=False
            
            #logic
            if self.flag: #to avoid unnecessary traversal after flag is False
                inorder(root.left,min,root.val)
            if self.flag: #to avoid unnecessary traversal after flag is False
                inorder(root.right,root.val,max)
        inorder(root,None,None)
        return self.flag



        #If you move line 32 to 35 after 39(In Order) or after 41(Post Order) it will still work. Here order of iteration doesn't matter