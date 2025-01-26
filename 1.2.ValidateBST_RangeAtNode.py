# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    """
    Time Complexity: 0(n)
    Space Complexity: 0(h) where h is height of tree
    Approach:
        Maintain range at every node during traversal
    """

    def __init__(self):
        self.isValid = True
    
    def __traversal(self, node: Optional[TreeNode], node_min: float, node_max: float) -> None:
        # base-case
        if node == None:
            return

        # logic-case -- inorder traversal
        
        #go-lft
        self.__traversal(node.left, node_min, node.val)

        # in-root -- comparison
        if node_min >= node.val or node.val >= node_max:
            # invalid case
            self.isValid = False
            return
        
        #go-rt
        self.__traversal(node.right, node.val, node_max)
        
        return

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.__traversal(root, float('-inf'), float('inf'))

        return self.isValid