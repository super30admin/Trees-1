#https://leetcode.com/problems/validate-binary-search-tree/
#Time comp: O(N) 
#space: O(h) 
#Approach 1: 
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        def inorder(node, left , right ):
            if not node:
                return True
            if not (node.val > left and node.val < right):
                return False
           
           
            return (inorder(node.left, left, node.val)) and (inorder(node.right, node.val, right  ))

        return inorder(root, float("-inf"), float ("inf"))
