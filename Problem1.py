class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        

        def BST (root,min1,max1):
                

            if not root:
                return True

            if root.val<min1 or root.val>max1 or root.val==min1 or root.val==max1:
                return False

            return (BST(root.left,min1,root.val) and BST (root.right,root.val,max1))
        
        
        
        min1 = -sys.maxsize
        max1 = sys.maxsize
        return BST(root,min1,max1)
        
