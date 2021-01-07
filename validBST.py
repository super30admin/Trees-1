class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        '''
        Time Complexity : O(logn)
        space complexity : O(logn)

        approch setting upper limit and lower limit at each Node
        '''
        def isvalid(root,ll,ul):
            if root == None: return True
            # print(ll,root.val,ul)
            if root.val <= ll or root.val >= ul:
                return False
            return isvalid(root.left,ll,root.val) and isvalid(root.right,root.val,ul)
        ll = -float('inf')
        ul = float('inf')
        return isvalid(root,ll,ul)