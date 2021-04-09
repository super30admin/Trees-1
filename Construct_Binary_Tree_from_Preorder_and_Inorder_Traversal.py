# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
    
        self.in_map = {}
    
        # Create a hashmap of index location from inorder for constant time lookup
        for idx, elem in enumerate(inorder):
            self.in_map[elem] = idx
            
        self.index = 0            
        
        def helper(s_idx = 0, e_idx = len(preorder)-1):
        
            ### Base Case
            if s_idx > e_idx:
                return
            
            ### Logic
            
            # Initialize TreeNode structure of processing node
            root = TreeNode(preorder[self.index])         
            self.index += 1
            
            # Find Position of processing node in inorder map
            r_idx = self.in_map[root.val]
            
            # Recursively create Left and Right Sub-Tree
            root.left = helper(s_idx, r_idx-1)
            root.right = helper(r_idx+1, e_idx)

            return root
    
        return helper()


### Complexity Analysis:

# Time Complexity: O(N) --> N = number of nodes
# Space Complexity: O(H) --> H = height of tree occupied by recursive stack