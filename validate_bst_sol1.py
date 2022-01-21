# tc : O(n)
# sc O(height(tree))
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        temp = root
        self.prev = ""
        def helper(root):
            if root: # root not None
                left_res = helper(root.left)
                curr_val = root.val 
                if self.prev != "" :
                    if self.prev >= curr_val:
                        return False
                self.prev = curr_val    
                right_res = helper(root.right)
                return left_res and right_res
            return True
        return helper(temp)