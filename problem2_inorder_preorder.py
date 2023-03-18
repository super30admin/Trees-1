'''
Approach 1: Recursive
TC: O(n)
SC: O(n) for recursive stack

'''


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #base condition
        if not inorder:
            return 
        
        #finding the root node's index in inorder traversal as root node is the last value in post order
        root_val = preorder.pop(0)
        idx_root = inorder.index(root_val)
        root = TreeNode(root_val)
        
        #left sub-tree
        root.left = self.buildTree(preorder, inorder[:idx_root])
        #right sub-tree
        root.right = self.buildTree(preorder, inorder[idx_root+1:])
        return root