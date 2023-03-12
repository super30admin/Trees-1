#Time Complexity : O(N), N being the number of values in tree. 
#Space Complexity : O(h), h being the height of the tree, or O(logN).
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Started out getting stuck on how to check 
# the entire side. Afterwards, used the order of recursion and a prev value to do.

#Your code here along with comments explaining your approach in three sentences only
'''Used order of recursion and initialized prev value to make sure the inorder traversal
 of values are sorted. 
'''
class Solution:
    #initialize a self.prev. 
    def __init__(self):
        self.prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        #base case
        if root==None:
            return True
        else:
            left = self.isValidBST(root.left)
            #if left is False, return False right away. 
            if left ==False:
                return False
            #check if the root greater than self.prev. If not, return False. 
            if self.prev!=None:
                if self.prev>=root.val:
                    return False
            #save root.val to self.prev
            self.prev=root.val
            right = self.isValidBST(root.right)
            #return the and of left and right. 
            return left and right
