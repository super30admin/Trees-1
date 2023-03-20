# time complexity - O(n) where n is no of nodes in the tree
# space complexity - O(1)
# worked on leetcode - yes
# logic - every node has left and right limits in which it has to lie.So, create 
# a valid function taht takes node , left and right in which the node.val has to lie
# for root it will be -INF and INF and for the remaining nodes on left, it should lie between
# -INF and its parent node , on right every element should lie between parent node and INF

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def valid(node,left,right):
            if not node:
                return True
            if not (node.val > left and node.val < right):
                return False
            return (valid(node.left,left,node.val) and valid(node.right,node.val,right))
        return valid(root,float("-inf"),float("inf"))
       