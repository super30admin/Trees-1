# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Three line explanation of solution in plain english : Extract leftmost node in the preorder list , that will be the root. Now remove that node from the list. After that, split the inorder 
# list to get the elements to the left of the root, and elements to thr right of the root. Recusrsively construct left and right trees the same way and attach to root node.


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder.pop(0))
        
        mid = inorder.index(root.val)
        left = inorder[:mid]
        right = inorder[mid+1:]
        
        root.left = self.buildTree(preorder, left)
        root.right = self.buildTree(preorder, right)
        
        return root
        
        
        