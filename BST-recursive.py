#O(n) time and O(depth) sapce.

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
      
        def recursiveBST(root,lower,upper):
            if root==None: return True
            if not(root.val>lower and root.val<upper): return False

            return recursiveBST(root.left,lower,root.val) and recursiveBST(root.right,root.val,upper)         

        return recursiveBST(root,float('-inf'),float('+inf'))

