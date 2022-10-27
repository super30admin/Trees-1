# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of binary tree
class Solution:
    def checkValidBST(self,node,min_value,max_value) -> bool:
        if node == None:
            return True
        elif not (min_value < node.val and node.val < max_value):
            print(node.val)
            return False
        else:
            return self.checkValidBST(node.left,min_value,node.val) and self.checkValidBST(node.right,node.val,max_value)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        min_value = -1*sys.maxsize
        max_value = sys.maxsize
        return self.checkValidBST(root,min_value,max_value)
