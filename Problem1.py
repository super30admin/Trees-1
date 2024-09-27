#Trees-1
#Problem1 : https://leetcode.com/problems/validate-binary-search-tree/
#All test cases passed on Leetcode
#Time Complexity-O(N)
#Space Complexity-O(N)
class Solution:
    def __init__(self):
        self.prev=None

    def isValidBST(self, root: TreeNode) -> bool:
        return self.inorder(root)

    def inorder(self,root):
        if root==None:
            return True
        if self.inorder(root.left)== False:
            return False
        if self.prev!=None and self.prev.val>=root.val:
            return False
        self.prev=root
        return self.inorder(root.right)
    
        


        
        















