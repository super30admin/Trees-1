class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def validate(root,lower,upper):
            if root is None:
                return True
            else:
                if root.val<=lower or root.val>=upper:
                    return False
            return (validate(root.left,lower,root.val) and validate(root.right,root.val,upper))
        return(validate(root,float('-inf'),float('inf')))