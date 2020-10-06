# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Three line explanation of solution in plain english : 
# A valid BST is one where the inorder traversal of the tree gives us a sorted array of unique numbers. Check for that


# Definition for a binary tree node.
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        self.result = []
        def inorder(root):
            if root:
                inorder(root.left)
                self.result.append(root.val)
                inorder(root.right)
                
        inorder(root)
        
        return self.result == (sorted(set(self.result)))
        