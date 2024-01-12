#Problem: Construct Binary Tree from Preorder and Inorder Traversal
#Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
#Time Complexity: O(n)
#Space Complexity: O(n)
#Approach: We know that the first element in the preorder traversal is the root. We find the index of the root in the inorder traversal. All the elements to the left of the root index in the inorder traversal are the left subtree and all the elements to the right of the root index in the inorder traversal are the right subtree. We recursively build the left and right subtree.

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        
        root_val = preorder.pop(0)
        root = TreeNode(root_val)
        
        root_index = inorder.index(root_val)
        
        root.left = self.buildTree(preorder, inorder[:root_index])
        root.right = self.buildTree(preorder, inorder[root_index + 1:])
        
        return root