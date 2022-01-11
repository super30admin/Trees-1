class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root, left_max = -math.inf, right_max = math.inf):
            if not root:
                return True
            if root.val <= left_max or root.val >= right_max:
                return False 
            return (  helper(root.right, root.val, right_max) and 
                    helper(root.left, left_max, root.val)   )
        return helper(root)
           
'''
call the func with and and check the condition for left and right sub trees 
recur until the current node is None 
check if the current node's val is falling between the left and the right node values

'''
