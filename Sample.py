## Validate BST
class Solution:
    def isValid
    BST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.dfs(root,None,None)
    
    def dfs(self,root:Optional[TreeNode], min:int, max:int):
        if root == None:
            return True
        if (min!=None and root.val <= min) or (max!=None and root.val >= max):
            return False
        return self.dfs(root.left, min, root.val) and self.dfs(root.right,root.val, max)

## Binary Tree from Inorder 
    # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {}
        for i, val in enumerate(inorder):
            inorder_map[val] = i
        
        # Recursively build the tree using the preorder and inorder lists
        def build_tree(pre_start, pre_end, in_start, in_end):
            if pre_start > pre_end:
                return None
            
            # Create a new node using the first element in the preorder list
            root_val = preorder[pre_start]
            root = TreeNode(root_val)
            
            # Find the index of the root element in the inorder list
            root_index = inorder_map[root_val]
            
            # Calculate the size of the left subtree
            left_size = root_index - in_start
            
            # Recursively build the left and right subtrees
            root.left = build_tree(pre_start+1, pre_start+left_size, in_start, root_index-1)
            root.right = build_tree(pre_start+left_size+1, pre_end, root_index+1, in_end)
            
            return root
        
        # Call the build_tree function with the initial indices
        return build_tree(0, len(preorder)-1, 0, len(inorder)-1)