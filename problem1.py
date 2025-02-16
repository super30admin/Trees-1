'''
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        isValid = True
        prev = None

        def inOrder(node):
            nonlocal prev, isValid
            if not node: return
            if isValid: inOrder(node.left)
            if prev and prev.val >= node.val: 
                isValid = False
            prev = node
            if isValid: inOrder(node.right)
            
        inOrder(root)
        return isValid
